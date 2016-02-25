package com.mikemilla.wordnerd.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.data.WordNerdApplication;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

public class AboutActivity extends BaseGameActivity {

    GoogleApiClient mGoogleApiClient;
    EightBitNominalTextView signOutButton;
    Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Google Analytics
        WordNerdApplication application = (WordNerdApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mGoogleApiClient = getApiClient();

        // Close Button
        ImageButton closeButton = (ImageButton) findViewById(R.id.close_button);
        closeButton.setColorFilter(ContextCompat.getColor(AboutActivity.this, R.color.white));
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        EightBitNominalTextView websiteButton = (EightBitNominalTextView) findViewById(R.id.web_button);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Website Button Click")
                        .build());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mikemilla.com"));
                startActivity(browserIntent);
            }
        });

        EightBitNominalTextView tweetButton = (EightBitNominalTextView) findViewById(R.id.tweet_button);
        tweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Tweet Button Click")
                        .build());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/home/?status=@killamikemilla%20"));
                startActivity(browserIntent);
            }
        });

        signOutButton = (EightBitNominalTextView) findViewById(R.id.sign_out_google_play);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Games.signOut(mGoogleApiClient);
                Defaults.setSignIntoGooglePlayGames(false, AboutActivity.this);
                signOutButton.setVisibility(View.GONE);
            }
        });

        EightBitNominalTextView contactMeTextView = (EightBitNominalTextView) findViewById(R.id.contact_me_text_view);
        contactMeTextView.setText("If words are missing\n\nContact the creator");

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
        signOutButton.setVisibility(View.VISIBLE);
    }
}
