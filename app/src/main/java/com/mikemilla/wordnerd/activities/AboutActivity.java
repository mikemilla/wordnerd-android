package com.mikemilla.wordnerd.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends BaseGameActivity {

    GoogleApiClient mGoogleApiClient;
    EightBitNominalTextView signOutButton;

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
                onBackPressed();
            }
        });

        EightBitNominalTextView websiteButton = (EightBitNominalTextView) findViewById(R.id.footer);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mikemilla.com"));
                startActivity(browserIntent);
            }
        });

        final LinearLayout pagination = (LinearLayout) findViewById(R.id.pagination);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        Adapter adapter = new Adapter(getSupportFragmentManager(), getApplicationContext());
        adapter.addFragment(PageFragment.newInstance("Rhymes dont have to be exact"));
        adapter.addFragment(PageFragment.newInstance("Score is the amount of syllables you played"));
        adapter.addFragment(PageFragment.newInstance("Swear words are acceptable"));
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setDot(pagination, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
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

    }

    public void setDot(LinearLayout parent, int position) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            parent.getChildAt(i).setAlpha(0.1f);
        }
        parent.getChildAt(position).setAlpha(1f);
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

    static class Adapter extends FragmentStatePagerAdapter {

        private final List<PageFragment> mFragments = new ArrayList<>();
        private Context context;

        public Adapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        public void addFragment(PageFragment fragment) {
            mFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
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
