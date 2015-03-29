package com.mikemilla.wordnerd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.plus.Plus;

public class ScoreActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{

    Button restart;
    TextView finalScore;
    TextView mainMenu;
    TextView bestText;
    TextView bestScore;
    TextView heyMike;

    int newScore = GameActivity.points;
    int best;

    public TextView rhymes;
    public Typeface font;

    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = "WordNerd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();

        restart = (Button) findViewById(R.id.restart_game);
        finalScore = (TextView) findViewById(R.id.final_score);
        mainMenu = (TextView) findViewById(R.id.main_menu);
        bestText = (TextView) findViewById(R.id.best_text);
        bestScore = (TextView) findViewById(R.id.best_score);
        heyMike = (Button) findViewById(R.id.send_feedback);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.no_change, R.anim.slide_up);
            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity1.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_down, R.anim.no_change_slow);
            }
        });

        finalScore.setText("" + GameActivity.points);

        font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/OldSansBlack.ttf");

        mainMenu.setTypeface(font);
        finalScore.setTypeface(font);
        restart.setTypeface(font);
        bestText.setTypeface(font);
        bestScore.setTypeface(font);
        heyMike.setTypeface(font);

        highScore();
        Log.v("USER", "" + GameActivity.hashedRhymes);
        Log.v("COMPUTER", "" + GameActivity.words);

        //lastRhyme.setText("" + GameActivity.generatedWord);
    }

    private void highScore() {

        int newBest = newScore;

        SharedPreferences prefs = this.getSharedPreferences("com.mikemilla.wordnerd", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int oldBest = prefs.getInt("newScore", best);

        if (newBest > oldBest) {
            editor.putInt("newScore", newBest);
            editor.apply();
            bestScore.setText("" + newBest);
            if (mGoogleApiClient.isConnected()) {
                Games.Leaderboards.submitScore(mGoogleApiClient, "leaderboard_high_scores", newBest);
            }
        }

        else {
            bestScore.setText("" + oldBest);
            if (mGoogleApiClient.isConnected()) {
                Games.Leaderboards.submitScore(mGoogleApiClient, "leaderboard_high_scores", oldBest);
            }
        }
    }

    /*
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(R.anim.no_change, R.anim.slide_up);
    }
    */

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScoreActivity.this, MainActivity1.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_up_in, R.anim.slide_right);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mGoogleApiClient.isConnected()) {
            Toast.makeText(getApplicationContext(), "onStart - Already Connected", Toast.LENGTH_LONG).show();
        }
        else {
            mGoogleApiClient.connect();
            Toast.makeText(getApplicationContext(), "onStart - Not Already Connected", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(TAG, "onConnected() called. Sign in successful!");
        Toast.makeText(getApplicationContext(), "onConnected - Connected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "onConnectionSuspended() called. Trying to reconnect.");
        Toast.makeText(getApplicationContext(), "onConnectionSuspended - Trying to Reconnect", Toast.LENGTH_LONG).show();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed() called, result: " + connectionResult);
    }
}
