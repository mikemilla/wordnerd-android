package com.mikemilla.wordnerd.activities;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.games.Games;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.data.Defaults;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

public class ScoreFragment extends Fragment {

    private static final int REQUEST_LEADERBOARD = 0;
    private static final int REQUEST_ACHIEVEMENTS = 1;
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

        // Last score that was played
        int lastScore = getArguments().getInt(SCORE_KEY);

        // Unlock Achievements Google Play Games
        if (gameActivity.getGoogleApiClient() != null && gameActivity.getGoogleApiClient().isConnected()) {
            unlockAchievements(lastScore);
        }

        int highScore = preferences.getInt(HIGH_SCORE_KEY, 0);
        if (lastScore > highScore) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(HIGH_SCORE_KEY, lastScore);
            editor.apply();
            Toast.makeText(gameActivity, "New Best Score", Toast.LENGTH_SHORT).show();
            highScoreTextView.setText(String.valueOf(lastScore));

            // Set new high score on Google Play Games
            if (gameActivity.getGoogleApiClient() != null && gameActivity.getGoogleApiClient().isConnected()) {
                Games.Leaderboards.submitScore(gameActivity.getGoogleApiClient(),
                        getString(R.string.leaderboard_high_scores), lastScore);
            }

        } else {
            highScoreTextView.setText(String.valueOf(highScore));
        }
        scoreTextView.setText(String.valueOf(lastScore));

        try {
            Log.d("Current Word", gameActivity.words.get(getArguments().getInt(CURRENT_WORD_INDEX_KEY)).getWord());
            Log.d("Current Entry", gameActivity.rhymeEntry.getText().toString());
            //Log.d("Current Acceptables", gameActivity.words.get(getArguments().getInt(CURRENT_WORD_INDEX_KEY)).getSingles()
                    //+ gameActivity.words.get(getArguments().getInt(CURRENT_WORD_INDEX_KEY)).getDoubles().toString());
        } catch (Exception e) {
            Toast.makeText(gameActivity, "" + e, Toast.LENGTH_SHORT).show();
        }

        // Tint Back Button Color
        gameActivity.backButton.setColorFilter(ContextCompat.getColor(gameActivity, R.color.black));

        ImageView restartButton = (ImageView) view.findViewById(R.id.button_restart);

        // Change drawable button background
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            restartButton.setBackground(changeButtonDrawable());
        }
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameActivity.onBackPressed();
                gameActivity.rhymeGenerated.startAnimation(gameActivity.slideInRight);
            }
        });

        ImageView leaderboardButton = (ImageView) view.findViewById(R.id.button_leaderboards);
        //leaderboardButton.setColorFilter(ContextCompat.getColor(gameActivity, R.color.black));
        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameActivity.getGoogleApiClient() != null) {
                    if (gameActivity.getGoogleApiClient().isConnected()) {
                        startActivityForResult(Games.Leaderboards.getLeaderboardIntent(
                                gameActivity.getGoogleApiClient(),
                                getString(R.string.leaderboard_high_scores)), REQUEST_LEADERBOARD);
                    } else {
                        showGooglePlayDialog();
                    }
                }
            }
        });

        ImageView achievementsButton = (ImageView) view.findViewById(R.id.button_achievements);
        //achievementsButton.setColorFilter(ContextCompat.getColor(gameActivity, R.color.black));
        achievementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameActivity.getGoogleApiClient() != null) {
                    if (gameActivity.getGoogleApiClient().isConnected()) {
                        startActivityForResult(Games.Achievements.getAchievementsIntent(gameActivity.getGoogleApiClient()),
                                REQUEST_ACHIEVEMENTS);
                    } else {
                        showGooglePlayDialog();
                    }
                }
            }
        });

        return view;
    }

    private Drawable changeButtonDrawable() {
        int[] drawables = {
                R.drawable.button_restart_0,
                R.drawable.button_restart_1,
                R.drawable.button_restart_2,
                R.drawable.button_restart_3
        };

        try {
            return ContextCompat.getDrawable(gameActivity, drawables[gameActivity.colorIndex]);
        } catch (Exception e) {
            return ContextCompat.getDrawable(gameActivity, drawables[0]);
        }
    }

    public void showGooglePlayDialog() {
        new AlertDialog.Builder(gameActivity)
                .setTitle("Sign into Google Play Games?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Defaults.setSignIntoGooglePlayGames(true, gameActivity);
                        gameActivity.getGameHelper().beginUserInitiatedSignIn();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Defaults.setSignIntoGooglePlayGames(false, gameActivity);
                    }
                })
                .show();
    }

    public static ScoreFragment newInstance(int score, int currentIndex) {

        ScoreFragment fragment = new ScoreFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SCORE_KEY, score);
        bundle.putInt(CURRENT_WORD_INDEX_KEY, currentIndex);
        fragment.setArguments(bundle);

        return fragment;
    }

    public void unlockAchievements(int score) {
        Games.Achievements.unlock(gameActivity.getGoogleApiClient(), getString(R.string.achievement_rhyme_time)); // First Rhyme
        if (score >= 10) {
            Games.Achievements.unlock(gameActivity.getGoogleApiClient(), getString(R.string.achievement_decade_made)); // Ten Points
        }
        if (score >= 20) {
            Games.Achievements.unlock(gameActivity.getGoogleApiClient(), getString(R.string.achievement_spaghetti_twenty)); // Twenty Points
        }
        if (score >= 30) {
            Games.Achievements.unlock(gameActivity.getGoogleApiClient(), getString(R.string.achievement_dirty_thirty)); // Thirty Points
        }
        if (score >= 40) {
            Games.Achievements.unlock(gameActivity.getGoogleApiClient(), getString(R.string.achievement_forty_shortie)); // Forty Points
        }
    }

}