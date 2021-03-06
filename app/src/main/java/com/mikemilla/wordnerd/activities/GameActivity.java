package com.mikemilla.wordnerd.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.data.WordNerdApplication;
import com.mikemilla.wordnerd.data.Words;
import com.mikemilla.wordnerd.views.AndroidBug5497Workaround;
import com.mikemilla.wordnerd.views.EightBitNominalEditText;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class GameActivity extends BaseGameActivity {

    // User Interface
    RelativeLayout openKeyboardView;
    ScoreFragment scoreFragment;
    GooglePlayGamesFragment gamesFragment;
    EightBitNominalTextView scoreTextView;
    EightBitNominalEditText rhymeEntry;
    EightBitNominalTextView rhymeGenerated;
    View rhymeWithView;
    View bobbleView;
    ImageButton backButton;
    CountDownTimer countdownTimer;
    ProgressBar progressBar;
    Boolean isKeyboardOpen = false;
    boolean canShowKeyboardView = false;
    boolean isGameOver = false;
    Animation slideOutLeft, slideInRight, backButtonSlideOutLeft, backButtonSlideInLeft, shake;
    ImageView cursorView;
    AnimationDrawable animationA, animationB, animationC;
    int progress;
    Tracker mTracker;

    // Data
    ArrayList<Words> words = new ArrayList<>();
    HashSet<String> hashedRhymes = new HashSet<>();
    int index = 0;
    int score;
    int colorIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Google Analytics
        WordNerdApplication application = (WordNerdApplication) getApplication();
        mTracker = application.getDefaultTracker();

        words = Defaults.getWordList(GameActivity.this);
        Collections.shuffle(words);

        // Keyboard / Full screen Bug Fix
        AndroidBug5497Workaround.assistActivity(this);

        // Set background color
        findViewById(R.id.main).setBackgroundColor(changeBackgroundColor());

        // Fixes keyboard glitches
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                canShowKeyboardView = true;
            }
        }, 1000);

        // Open Keyboard View
        openKeyboardView = (RelativeLayout) findViewById(R.id.open_keyboard_view);
        openKeyboardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isKeyboardOpen) {
                    openKeyboard();
                }
            }
        });

        // Check keyboard status
        final View rootView = getWindow().getDecorView().findViewById(R.id.main);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {

                int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
                isKeyboardOpen = heightDiff >= 150;

                //Log.d("heightDiff", "" + heightDiff);
                //Log.d("isKeyboardOpen", "" + isKeyboardOpen);

                if (isKeyboardOpen) {
                    Log.d("Keyboard", "Opened");
                    rhymeEntry.setTextSize(32); // Fixes Bug
                    openKeyboardView.setVisibility(View.GONE);
                } else {
                    Log.d("Keyboard", "Closed");
                    rhymeEntry.setTextSize(0); // Fixes Bug
                    if (canShowKeyboardView) {
                        openKeyboardView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        // Animated cursor view
        animationA = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.animation_a);
        animationB = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.animation_b);
        animationC = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.animation_c);
        cursorView = (ImageView) findViewById(R.id.cursor_animation_view);
        cursorView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setRandomCursorAnimation();

        // Back Button
        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(GameActivity.this, R.color.white));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                GameActivity.this.finish();
                overridePendingTransition(R.anim.scale_in, R.anim.slide_out_down);
            }
        });

        // Setup Score TextView
        scoreTextView = (EightBitNominalTextView) findViewById(R.id.score);

        // Rhyme entry area and text change listener
        rhymeEntry = (EightBitNominalEditText) findViewById(R.id.rhyme_entry);

        // IME Action
        rhymeEntry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_PREVIOUS) {
                    rhymeEntry.setText(null);
                    handled = true;
                }
                return handled;
            }
        });

        rhymeEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!isGameOver) {

                    String space = s.toString().replaceAll(" ", "");
                    String back = s.toString().replaceAll("\\u003F", "");
                    if (!s.toString().equals(space)) {
                        rhymeEntry.setText(space);
                        rhymeEntry.setSelection(space.length());
                    }

                    if (!s.toString().equals(back)) {
                        rhymeEntry.setText(back);
                        rhymeEntry.setSelection(back.length());
                    }

                    if (rhymeEntry.getText().length() <= 0) {
                        cursorView.setVisibility(View.VISIBLE);
                        setRandomCursorAnimation();
                    } else {
                        cursorView.setVisibility(View.GONE);
                    }

                    // Engine
                    try {
                        String userInput = s.toString().toLowerCase();
                        if (!rhymeGenerated.getText().toString().equals(userInput)) {
                            if (!hashedRhymes.contains(userInput)) {
                                if (words.get(index).getSingles().contains(userInput)) {
                                    crunchTheWord(1, userInput);
                                } else if (words.get(index).getDoubles().contains(userInput)) {
                                    crunchTheWord(2, userInput);
                                } else if (words.get(index).getTriples().contains(userInput)) {
                                    crunchTheWord(3, userInput);
                                } else if (words.get(index).getQuadruples().contains(userInput)) {
                                    crunchTheWord(4, userInput);
                                } else if (words.get(index).getQuintuples().contains(userInput)) {
                                    crunchTheWord(5, userInput);
                                } else if (words.get(index).getSextuples().contains(userInput)) {
                                    crunchTheWord(6, userInput);
                                } else if (words.get(index).getSeptuples().contains(userInput)) {
                                    crunchTheWord(7, userInput);
                                } else if (words.get(index).getOctuples().contains(userInput)) {
                                    crunchTheWord(8, userInput);
                                } else if (words.get(index).getNonuples().contains(userInput)) {
                                    crunchTheWord(9, userInput);
                                } else if (words.get(index).getDecuples().contains(userInput)) {
                                    crunchTheWord(10, userInput);
                                }
                            } else {
                                rhymeEntry.startAnimation(shake); // Catch Duplicates
                            }
                        } else {

                            Log.d("Action", "Rhyme Matched Generated");
                            mTracker.send(new HitBuilders.EventBuilder()
                                    .setCategory("Action")
                                    .setAction("Rhyme Matched Generated")
                                    .build());

                            rhymeEntry.startAnimation(shake); // Catch Copy Generated
                        }
                    } catch (Exception e) {
                        Toast.makeText(GameActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        // Word to Rhyme with
        rhymeGenerated = (EightBitNominalTextView) findViewById(R.id.rhyme_generated);
        generateNewWord();

        // Setup Progressbar
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        // Create animations
        slideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        backButtonSlideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        backButtonSlideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rhymeEntry.setText(null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // Tip View
        rhymeWithView = findViewById(R.id.rhyme_with_view);
        bobbleView = findViewById(R.id.bobble_view);
        animateRhymeView(true);
    }

    public void animateRhymeView(boolean show) {
        if (show) {
            if (rhymeWithView.getVisibility() != View.VISIBLE) {
                rhymeWithView.setVisibility(View.VISIBLE);
            }
            hideBobble();
        } else {
            rhymeWithView.setVisibility(View.GONE);
            bobbleView.setVisibility(View.VISIBLE);
        }
    }

    public void hideBobble() {
        bobbleView.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showBobble();
            }
        }, 500);
    }

    public void showBobble() {
        bobbleView.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideBobble();
            }
        }, 500);
    }

    public void crunchTheWord(int pointsAwarded, String userInput) {

        // Make progress bar visible if hidden
        if (progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
            backButton.startAnimation(backButtonSlideOutLeft);
            backButtonSlideOutLeft.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    backButton.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }

        // Cancel timer if running
        if (index != 0) {
            countdownTimer.cancel();
        }

        // Start timer
        runCountdownTimer();

        // Reapply time animation
        progressBar.setProgress(4000);
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", progress);
        animation.setDuration(4000);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();

        // Increment, score, save words
        index++;
        score += pointsAwarded;
        hashedRhymes.add(userInput);
        Log.d("Rhymes Played", hashedRhymes.toString());

        if (score > 0) {
            animateRhymeView(false);
        }

        // Animate Word Change
        rhymeGenerated.startAnimation(slideOutLeft);
        slideOutLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    generateNewWord();
                    rhymeGenerated.startAnimation(slideInRight);
                } catch (Exception e) {
                    Toast.makeText(GameActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    countdownTimer.cancel();
                    onGameOver();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void generateNewWord() {

        rhymeGenerated.setText(words.get(index).getWord());
        rhymeEntry.setText(null);
        setRandomCursorAnimation();

        if (score == 0) {
            scoreTextView.setText(null);
        } else {
            scoreTextView.setText(String.valueOf(score));
            if (index == 1) {
                scoreTextView.startAnimation(slideInRight);
            }
        }

        //Log.d("Acceptable Rhymes", words.get(index).getSingles() + "" + words.get(index).getDoubles() + "");
    }

    private void runCountdownTimer() {
        countdownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress = (int) (millisUntilFinished / 1000);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                onGameOver();
            }
        };
        countdownTimer.start();
    }

    // When the timer runs out or out of words
    public void onGameOver() {

        isGameOver = true;

        Log.d("Last Rhyme Attempt", rhymeEntry.getText().toString());
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Last Rhyme Attempt")
                .setAction(rhymeEntry.getText().toString())
                .build());

        Log.d("Last Generated Rhyme", words.get(index).getWord());
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Last Generated Rhyme")
                .setAction(words.get(index).getWord())
                .build());

        Log.d("Played Rhymes", hashedRhymes.toString());
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Played Rhymes")
                .setAction(hashedRhymes.toString())
                .build());

        Log.d("Amount of Rhymes", "" + hashedRhymes.size());
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Amount of Rhymes")
                .setAction("" + hashedRhymes.size())
                .build());

        rhymeEntry.setText(null);
        countdownTimer.cancel();
        progressBar.setProgress(0);
        progressBar.setVisibility(View.GONE);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(250);

        scoreFragment = ScoreFragment.newInstance(score, index);
        if (findViewById(R.id.game_over_container) != null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_up, R.anim.scale_out)
                    .add(R.id.game_over_container, scoreFragment)
                    .commit();
        }

        // Show the back button
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backButton.setVisibility(View.VISIBLE);
                backButton.startAnimation(backButtonSlideInLeft);
            }
        }, 150);
    }

    // Generate a random animated drawable for the cursor
    public void setRandomCursorAnimation() {
        int min = 0;
        int max = 2;
        Random random = new Random();
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        AnimationDrawable animation = new AnimationDrawable();

        switch (randomNumber) {
            case 0: {
                animation = animationA;
                break;
            }
            case 1: {
                animation = animationB;
                break;
            }
            case 2: {
                animation = animationC;
                break;
            }
        }

        cursorView.setImageDrawable(animation);
        animation.start();
    }

    public int changeBackgroundColor() {

        // Get Color from array
        int[] colors = {
                R.color.green,
                R.color.deep_purple,
                R.color.red,
                R.color.amber
        };

        try {
            return ContextCompat.getColor(GameActivity.this, colors[colorIndex]);
        } catch (Exception e) {
            colorIndex = 0;
            return ContextCompat.getColor(GameActivity.this, colors[colorIndex]);
        }
    }

    public void openKeyboard() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(
                InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        rhymeEntry.requestFocus();
    }

    public void closeKeyboard() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(rhymeEntry.getWindowToken(), 0);
    }

    @Override
    public void onStart() {
        if (Defaults.getSignIntoGooglePlayGames(GameActivity.this)) {
            getGameHelper().setConnectOnStart(true);
        } else {
            getGameHelper().setConnectOnStart(false);
        }
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        //closeKeyboard();
    }

    @Override
    public void onStop() {
        super.onStop();
        closeKeyboard();
        if (countdownTimer != null) {
            countdownTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {

        if (gamesFragment != null && gamesFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                    .remove(gamesFragment)
                    .commit();
            return;
        }

        if (openKeyboardView.getVisibility() == View.VISIBLE) {
            super.onBackPressed();
            this.finish();
            overridePendingTransition(R.anim.scale_in, R.anim.slide_out_down);
        } else {

            // Change Background color
            colorIndex += 1;
            findViewById(R.id.main).setBackgroundColor(changeBackgroundColor());

            // Change Back Button Color
            backButton.setColorFilter(ContextCompat.getColor(GameActivity.this, R.color.white));

            // Remove Fragment
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.scale_in, R.anim.slide_out_down)
                    .remove(scoreFragment)
                    .commit();

            // Reset the game
            score = 0;
            index = 0;
            words = new ArrayList<>();
            words = Defaults.getWordList(GameActivity.this);
            Collections.shuffle(words);
            hashedRhymes = new HashSet<>();
            generateNewWord();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onSignInFailed() {
        //Toast.makeText(GameActivity.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignInSucceeded() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (getGoogleApiClient() != null && getGoogleApiClient().isConnected()) {
            Games.Leaderboards.submitScore(getGoogleApiClient(),
                    getString(R.string.leaderboard_high_scores), preferences.getInt(ScoreFragment.HIGH_SCORE_KEY, 0));
        }
    }

    public GoogleApiClient getGoogleApiClient() {
        return getApiClient();
    }
}