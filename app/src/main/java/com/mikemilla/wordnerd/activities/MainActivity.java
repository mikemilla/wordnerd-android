package com.mikemilla.wordnerd.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.gson.Gson;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.data.Response;
import com.mikemilla.wordnerd.data.WordNerdApplication;
import com.mikemilla.wordnerd.views.AvenirTextView;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends BaseGameActivity {

    Animation slideOutLeftWord, slideOutLeftNerd, slideInRight;
    GooglePlayGamesFragment gamesFragment;
    Tracker mTracker;
    boolean okFailed = false;
    boolean didCreateAnimation = false;
    OkHttpClient ok = new OkHttpClient();
    EightBitNominalTextView titleWord, titleNerd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Google Analytics
        WordNerdApplication application = (WordNerdApplication) getApplication();
        mTracker = application.getDefaultTracker();

        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Background Color
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);
        main.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));

        // Menu Button
        EightBitNominalTextView rateButton = (EightBitNominalTextView) findViewById(R.id.rate_button);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okFailed) {
                    try {
                        run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Action")
                            .setAction("Rate Button Click")
                            .build());

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.mikemilla.wordnerd"));
                    startActivity(browserIntent);
                }
            }
        });

        // Menu Button
        EightBitNominalTextView menuButton = (EightBitNominalTextView) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okFailed) {
                    try {
                        run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Action")
                            .setAction("More Button Click")
                            .build());

                    Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_up, R.anim.scale_out);
                }
            }
        });

        // Set Title Text
        ImageButton mStartGameButton = (ImageButton) findViewById(R.id.start_game);
        mStartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Start Game Button Click")
                        .build());

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.scale_out);
            }
        });

        // Set Title Text
        titleWord = (EightBitNominalTextView) findViewById(R.id.title_word);
        titleNerd = (EightBitNominalTextView) findViewById(R.id.title_nerd);

        // Create animations
        slideOutLeftWord = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        slideOutLeftNerd = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);

        if (!didCreateAnimation) {
            didCreateAnimation = true;
            titleWord.setText("Word");
            titleNerd.setText("Nerd");
            runOpeningAnimation();
        }

        AvenirTextView copyrightTextView = (AvenirTextView) findViewById(R.id.copyright_text_view);
        copyrightTextView.setText("© Michael Miller " + Calendar.getInstance().get(Calendar.YEAR));
    }

    public void runOpeningAnimation() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                titleWord.startAnimation(slideOutLeftWord);
                titleNerd.startAnimation(slideOutLeftNerd);
            }
        }, 4000);

        slideOutLeftWord.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                titleWord.startAnimation(slideInRight);
                titleNerd.setText(null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        slideInRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        titleNerd.setText("N");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                titleNerd.setText("Ne");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        titleNerd.setText("Ner");
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                titleNerd.setText("Nerd");
                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        titleWord.startAnimation(slideOutLeftWord);
                                                        titleNerd.startAnimation(slideOutLeftNerd);
                                                    }
                                                }, 4000);
                                            }
                                        }, 100);
                                    }
                                }, 100);
                            }
                        }, 100);
                    }
                }, 500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://www.mikemilla.com/words.json")
                .build();

        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                // Create response object
                Response responseObj = new Gson().fromJson(response.body().charStream(), Response.class);

                // Save Response object to shared preference "of sorts"
                Defaults.setWordList(responseObj, MainActivity.this);
                Log.d("Response Successful", response.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onStart() {
        if (Defaults.getShowGooglePlayGamesDialog(MainActivity.this)) {
            getGameHelper().setConnectOnStart(false);
            Defaults.setShowGooglePlayGamesDialog(false, MainActivity.this);
            showGooglePlayDialog();
        } else {
            if (Defaults.getSignIntoGooglePlayGames(MainActivity.this)) {
                getGameHelper().setConnectOnStart(true);
            } else {
                getGameHelper().setConnectOnStart(false);
            }
        }
        super.onStart();
    }

    @Override
    public void onBackPressed() {

        if (gamesFragment == null || !gamesFragment.isAdded()) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                    .remove(gamesFragment)
                    .commit();
        }

    }

    public void showGooglePlayDialog() {
        gamesFragment = GooglePlayGamesFragment.newInstance(this);
        if (findViewById(R.id.google_play_games_frame) != null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                    .add(R.id.google_play_games_frame, gamesFragment)
                    .commit();
        }
    }

    /**
     * Google Play Games
     */
    @Override
    public void onSignInFailed() {
        Log.d("Google Play Sign In", "FAILED");
    }

    @Override
    public void onSignInSucceeded() {
        Log.d("Google Play Sign In", "SUCCESS");
    }

}
