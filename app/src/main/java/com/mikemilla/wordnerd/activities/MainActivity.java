package com.mikemilla.wordnerd.activities;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

import java.io.File;

public class MainActivity extends Activity {

    private EightBitNominalTextView startGameButton;
    private Animation fadeIn, fadeOut;
    public static boolean isFirstLoad = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);

        // Get the latest words or make a new json for them
        if (isOnline() && isFirstLoad) {
            updateWordList();
            isFirstLoad = false;
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
    }

    private void updateWordList() {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://www.mikemilla.com/words.json"));
        request.allowScanningByMediaScanner();

        //getApplicationContext().getFilesDir().getAbsolutePath()
        String filename = "words.json";
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);
        if (file.exists()) {
            file.delete();
            Toast.makeText(MainActivity.this, "Updated Words!", Toast.LENGTH_SHORT).show();
        }

        // get download service and enqueue file
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
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
}
