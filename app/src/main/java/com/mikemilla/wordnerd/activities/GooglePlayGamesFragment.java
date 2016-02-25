package com.mikemilla.wordnerd.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.data.WordNerdApplication;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

public class GooglePlayGamesFragment extends Fragment {

    BaseGameActivity activity;
    Tracker mTracker;

    public GooglePlayGamesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Google Analytics
        WordNerdApplication application = (WordNerdApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_google_play_games, container, false);

        // Style ImageViews
        ImageView achievementsImage = (ImageView) view.findViewById(R.id.achievements_image);
        ImageView leaderboardsImage = (ImageView) view.findViewById(R.id.leaderboard_image);
        achievementsImage.setColorFilter(ContextCompat.getColor(activity, R.color.amber));
        leaderboardsImage.setColorFilter(ContextCompat.getColor(activity, R.color.blue));

        RelativeLayout background = (RelativeLayout) view.findViewById(R.id.main);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });

        EightBitNominalTextView yesButton = (EightBitNominalTextView) view.findViewById(R.id.yes_button);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Google Play Sign In - Yes Click")
                        .build());

                activity.onBackPressed();
                Defaults.setSignIntoGooglePlayGames(true, activity);
                activity.getGameHelper().beginUserInitiatedSignIn();
            }
        });

        EightBitNominalTextView noButton = (EightBitNominalTextView) view.findViewById(R.id.no_button);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Google Play Sign In - No Click")
                        .build());

                activity.onBackPressed();
                Defaults.setSignIntoGooglePlayGames(false, activity);
            }
        });

        return view;
    }

    public static GooglePlayGamesFragment newInstance(BaseGameActivity activity) {

        GooglePlayGamesFragment fragment = new GooglePlayGamesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        // Pass activity
        fragment.activity = activity;

        return fragment;
    }

}