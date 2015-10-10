package com.mikemilla.wordnerd.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

public class ScoreFragment extends Fragment {

    public static String SCORE_KEY = "score";
    public static String HIGH_SCORE_KEY = "high_score";
    public static String CURRENT_WORD_INDEX_KEY = "current_word_index";
    GameActivity gameActivity;
    EightBitNominalTextView scoreTextView;
    EightBitNominalTextView highScoreTextView;

    public ScoreFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        // Reference the parent activity
        gameActivity = (GameActivity) getActivity();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(gameActivity);

        scoreTextView = (EightBitNominalTextView) view.findViewById(R.id.score_text_view);
        highScoreTextView = (EightBitNominalTextView) view.findViewById(R.id.high_score_text_view);

        int highScore = preferences.getInt(HIGH_SCORE_KEY, 0);
        if (getArguments().getInt(SCORE_KEY) > highScore) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(HIGH_SCORE_KEY, getArguments().getInt(SCORE_KEY));
            editor.apply();
            Toast.makeText(gameActivity, "New Best Score", Toast.LENGTH_SHORT).show();
            highScoreTextView.setText(String.valueOf(getArguments().getInt(SCORE_KEY)));
        } else {
            highScoreTextView.setText(String.valueOf(highScore));
        }
        scoreTextView.setText(String.valueOf(getArguments().getInt(SCORE_KEY)));

        Log.d("Current Word", gameActivity.words.get(getArguments().getInt(CURRENT_WORD_INDEX_KEY)).getWord());
        Log.d("Current Acceptables", gameActivity.words.get(getArguments().getInt(CURRENT_WORD_INDEX_KEY)).getSingles()
                + gameActivity.words.get(getArguments().getInt(CURRENT_WORD_INDEX_KEY)).getDoubles().toString());

        View dummy = view.findViewById(R.id.dummy);
        dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameActivity.onBackPressed();
            }
        });

        return view;
    }

    public static ScoreFragment newInstance(int score, int currentIndex) {

        ScoreFragment fragment = new ScoreFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SCORE_KEY, score);
        bundle.putInt(CURRENT_WORD_INDEX_KEY, currentIndex);
        fragment.setArguments(bundle);

        return fragment;
    }

}