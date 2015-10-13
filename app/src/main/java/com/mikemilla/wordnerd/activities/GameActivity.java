package com.mikemilla.wordnerd.activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.mikemilla.wordnerd.AndroidBug5497Workaround;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.views.EightBitNominalEditText;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GameActivity extends FragmentActivity {

    // User Interface
    ScoreFragment scoreFragment;
    EightBitNominalTextView scoreTextView;
    EightBitNominalEditText rhymeEntry;
    EightBitNominalTextView rhymeGenerated;
    CountDownTimer countdownTimer;
    ProgressBar progressBar;
    int progress;
    Boolean isKeyboardOpen = false;

    // Data
    ArrayList<Words> words = new ArrayList<>();
    HashSet<String> hashedRhymes = new HashSet<>();
    int index = 0;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        // Get parsed word objects from Main Activity
        // I know it's static. Don't shoot me
        words = MainActivity.words;
        Collections.shuffle(words);

        // Keyboard / Full screen Bug Fix
        fixFullscreenKeyboardBug(this);

        // Check keyboard status
        final View rootView = getWindow().getDecorView().findViewById(R.id.main);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
                isKeyboardOpen = heightDiff >= 150;
                android.util.Log.d("heightDiff", "" + heightDiff);
                android.util.Log.d("isKeyboardOpen", "" + isKeyboardOpen);

                if (isKeyboardOpen) {
                    findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.blue));
                } else {
                    findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });

        // Main Content Area
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);
        main.setBackgroundColor(getResources().getColor(R.color.black));

        // Game Content Area
        RelativeLayout game = (RelativeLayout) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isKeyboardOpen) {
                    openKeyboard();
                }
            }
        });

        // Setup Score TextView
        scoreTextView = (EightBitNominalTextView) findViewById(R.id.score);

        // Rhyme entry area and text change listener
        rhymeEntry = (EightBitNominalEditText) findViewById(R.id.rhyme_entry);
        rhymeEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
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

                // Engine
                String userInput = s.toString().toLowerCase();
                if (!rhymeGenerated.getText().toString().equals(userInput)) {
                    if (!hashedRhymes.contains(userInput)) {
                        if (words.get(index).getSingles().contains(userInput)) {
                            crunchTheWord(1, userInput);
                            generateNewWord();
                        } else if (words.get(index).getDoubles().contains(userInput)) {
                            crunchTheWord(2, userInput);
                            generateNewWord();
                        }
                    } else {
                        rhymeEntry.setText(null);
                    }
                } else {
                    rhymeEntry.setText(null);
                }

            }
        });

        // Word to Rhyme with
        rhymeGenerated = (EightBitNominalTextView) findViewById(R.id.rhyme_generated);
        generateNewWord();

        // Setup Progressbar
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
    }

    public void crunchTheWord(int pointsAwarded, String userInput) {

        // Make progress bar visible if hidden
        if (progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
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
    }

    public void generateNewWord() {
        rhymeGenerated.setText(words.get(index).getWord());
        rhymeEntry.setText(null);

        if (score == 0) {
            scoreTextView.setText(null);
        } else {
            scoreTextView.setText(String.valueOf(score));
        }

        Log.d("Acceptable Rhymes", words.get(index).getSingles() + "" + words.get(index).getDoubles() + "");
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

                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(250);

                progressBar.setProgress(0);

                scoreFragment = ScoreFragment.newInstance(score, index);
                if (findViewById(R.id.game_over_container) != null) {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_up, R.anim.scale_out)
                            .add(R.id.game_over_container, scoreFragment)
                            .commit();
                }
            }
        };
        countdownTimer.start();
    }

    public void fixFullscreenKeyboardBug(final Activity activity) {

        // Turn off Fullscreen mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Turn on Fullscreen mode
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                AndroidBug5497Workaround.assistActivity(activity);
            }
        }, 100);
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
    public void onPause() {
        super.onPause();
        closeKeyboard();
    }

    @Override
    public void onBackPressed() {
        if (scoreFragment == null || !scoreFragment.isAdded()) {
            super.onBackPressed();
            this.finish();
            overridePendingTransition(R.anim.scale_in, R.anim.slide_out_down);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.scale_in, R.anim.slide_out_down)
                    .remove(scoreFragment)
                    .commit();

            // Reset the game
            score = 0;
            index = 0;
            words = new ArrayList<>();
            words = MainActivity.words;
            Collections.shuffle(words);
            hashedRhymes = new HashSet<>();
            generateNewWord();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

}
