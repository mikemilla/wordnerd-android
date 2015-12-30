package com.mikemilla.wordnerd.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.views.AndroidBug5497Workaround;

public class AboutActivity extends BaseGameActivity {

    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mGoogleApiClient = getApiClient();

        // Close Button
        ImageButton closeButton = (ImageButton) findViewById(R.id.close_button);
        closeButton.setColorFilter(ContextCompat.getColor(AboutActivity.this, R.color.white));
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
                    Games.signOut(mGoogleApiClient);
                    Defaults.setSignIntoGooglePlayGames(false, AboutActivity.this);
                }
                onBackPressed();
            }
        });

        AndroidBug5497Workaround.assistActivity(this);

    }

    @Override
    protected void onStart() {
        if (Defaults.getSignIntoGooglePlayGames(AboutActivity.this)) {
            getGameHelper().setConnectOnStart(true);
        } else {
            getGameHelper().setConnectOnStart(false);
        }
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        overridePendingTransition(R.anim.scale_in, R.anim.slide_out_down);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onSignInFailed() {
        Log.e("About", "onSignInFailed");
    }

    @Override
    public void onSignInSucceeded() {
        Log.e("About", "onSignInSucceeded");
    }
}
