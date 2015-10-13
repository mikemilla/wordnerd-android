package com.mikemilla.wordnerd.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.plus.Plus;
import com.google.gson.Gson;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private EightBitNominalTextView startGameButton;
    private Animation fadeIn, fadeOut;

    Gson gson;
    Response responseObj;
    OkHttpClient client;
    GoogleApiClient mGoogleApiClient;

    public static ArrayList<Words> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);

        // Get the latest words or make a new json for them
        File file = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(file, cacheSize);
        client = new OkHttpClient();
        client.setCache(cache);

        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Background Color
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);
        main.setBackgroundColor(getResources().getColor(R.color.blue));

        // Menu Button
        ImageButton menuButton = (ImageButton) findViewById(R.id.menu_button);
        menuButton.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        menuButton.setAlpha(0.54f);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.scale_out);
            }
        });

        // Set Title Text
        EightBitNominalTextView title = (EightBitNominalTextView) findViewById(R.id.title_text);
        title.setText("Word\nNerd");

        // Set Title Text
        startGameButton = (EightBitNominalTextView) findViewById(R.id.start_game);
        startGameButton.setText("Tap here to play");
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.scale_out);
            }
        });

        // Add Animations
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        // Start the Animation Loop
        animateTapToPlay();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();
    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://www.mikemilla.com/words.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                // Cache expiration
                response.header("Cache-Control: max-age=1800");

                gson = new Gson();
                responseObj = gson.fromJson(response.body().charStream(), Response.class);
                for (int i = 0; i < responseObj.getWords().size(); i++) {

                    // Add the words
                    String word = responseObj.getWords().get(i).getWord();

                    // Add the singles
                    ArrayList<String> singlesList = new ArrayList<>();
                    if (responseObj.getWords().get(i).getRhymes().getSingles() != null) {
                        for (int s = 0; s < responseObj.getWords().get(i).getRhymes().getSingles().size(); s++) {
                            String singles = responseObj.getWords().get(i).getRhymes().getSingles().get(s);
                            singlesList.add(singles);
                        }
                    }

                    // Add the Doubles
                    ArrayList<String> doublesList = new ArrayList<>();
                    if (responseObj.getWords().get(i).getRhymes().getDoubles() != null) {
                        for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getDoubles().size(); d++) {
                            String doubles = responseObj.getWords().get(i).getRhymes().getDoubles().get(d);
                            doublesList.add(doubles);
                        }
                    }

                    // Create a new word object
                    // Add it to the words list
                    words.add(new Words(word, singlesList, doublesList));

                }

                Log.d("Words Generated", words.toString());

            }
        });
    }

    private void animateTapToPlay() {
        startGameButton.setText("tap here to play");
        startGameButton.startAnimation(fadeIn);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGameButton.startAnimation(fadeOut);
                        fadeOut.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                animateRhymeWithTheWords();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void animateRhymeWithTheWords() {
        startGameButton.setText("rhyme with the words");
        startGameButton.startAnimation(fadeIn);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGameButton.startAnimation(fadeOut);
                        fadeOut.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                animateTapToPlay();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mGoogleApiClient.isConnected()) {
            Toast.makeText(getApplicationContext(), "onStart - Already Connected", Toast.LENGTH_LONG).show();
        } else {
            mGoogleApiClient.connect();
            Toast.makeText(getApplicationContext(), "onStart - Not Already Connected", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Google Play Games
     */
    @Override
    public void onConnected(Bundle bundle) {
        Log.d("Mike", "onConnected() called. Sign in successful!");
        Toast.makeText(getApplicationContext(), "onConnected - Connected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("Mike", "onConnectionSuspended() called. Trying to reconnect.");
        Toast.makeText(getApplicationContext(), "onConnectionSuspended - Trying to Reconnect", Toast.LENGTH_LONG).show();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("Mike", "onConnectionFailed() called, result: " + connectionResult);
    }
}
