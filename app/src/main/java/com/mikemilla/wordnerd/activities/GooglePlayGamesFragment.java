package com.mikemilla.wordnerd.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.example.games.basegameutils.BaseGameActivity;
import com.mikemilla.wordnerd.R;

public class GooglePlayGamesFragment extends Fragment {

    BaseGameActivity activity;

    public GooglePlayGamesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_google_play_games, container, false);

        RelativeLayout background = (RelativeLayout) view.findViewById(R.id.main);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
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