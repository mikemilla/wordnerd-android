package com.mikemilla.wordnerd;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity1 extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "WordNerd";

    // Request code used to invoke sign in user interactions.
    private static final int RC_SIGN_IN = 9001;

    private GoogleApiClient mGoogleApiClient;

    // Are we currently resolving a connection failure?
    private boolean mResolvingConnectionFailure = false;

    // Set to true to automatically start the sign in flow when the Activity starts.
    // Set to false to require the user to click the button in order to sign in.
    private boolean mAutoStartSignInFlow = true;

    public Button startGame;
    public Button openAchievements;
    public Button openLeaderboard;
    public TextView logo;
    public Typeface font;

    private static boolean firstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");

        super.onCreate(savedInstanceState);

        /*

        // Create the Google Api Client with access to Plus and Games
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();

        setContentView(R.layout.activity_main);

        openAchievements = (Button) findViewById(R.id.achievements);
        openLeaderboard = (Button) findViewById(R.id.leaderboards);

        openAchievements.setVisibility(View.GONE);
        openLeaderboard.setVisibility(View.GONE);

        startGame = (Button) findViewById(R.id.start_game);
        logo = (TextView) findViewById(R.id.logo);
        font = Typeface.createFromAsset(this.getAssets(), "fonts/OldSansBlack.ttf");

        startGame.setTypeface(font, Typeface.NORMAL);
        logo.setTypeface(font, Typeface.NORMAL);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.GAME");
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.no_change, R.anim.slide_up);
            }
        });

        openAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Games.Achievements.getAchievementsIntent(mGoogleApiClient), 7734);
            }
        });

        openLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Games.Leaderboards.getLeaderboardIntent(mGoogleApiClient, "leaderboard_high_scores"), 80085);
            }
        });
    }

    private void googlePlayLoginRequest() {

        if (!mGoogleApiClient.isConnected() && firstLaunch) {
            firstLaunch = false;
            Toast.makeText(getApplicationContext(), "first launch", Toast.LENGTH_LONG).show();
            mGoogleApiClient.connect();
        }
        else {
            Toast.makeText(getApplicationContext(), "not first launch", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        googlePlayLoginRequest();
        if (mGoogleApiClient.isConnected()) {
            openAchievements.setVisibility(View.VISIBLE);
            openLeaderboard.setVisibility(View.VISIBLE);
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
        this.finish();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(TAG, "onConnected() called. Sign in successful!");
        Toast.makeText(getApplicationContext(), "onConnected - Connected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "onConnectionSuspended() called. Trying to reconnect.");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed() called, result: " + connectionResult);

        if (mResolvingConnectionFailure) {
            Log.d(TAG, "onConnectionFailed() ignoring connection failure; already resolving.");
            return;
        }

        if (mAutoStartSignInFlow) {
            mAutoStartSignInFlow = false;
            mResolvingConnectionFailure = BaseGameUtils.resolveConnectionFailure(this, mGoogleApiClient,
                    connectionResult, RC_SIGN_IN, getString(R.string.signin_other_error));
        }
    }

    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        if (requestCode == RC_SIGN_IN) {
            Log.d(TAG, "onActivityResult with requestCode == RC_SIGN_IN, responseCode="
                    + responseCode + ", intent=" + intent);
            mResolvingConnectionFailure = false;
            if (responseCode == RESULT_OK) {
                mGoogleApiClient.connect();
            } else {
                BaseGameUtils.showActivityResultError(this,requestCode,responseCode,
                        R.string.signin_failure, R.string.signin_other_error);
            }
        }

        */

    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
