package com.mikemilla.wordnerd.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.mikemilla.wordnerd.AndroidBug5497Workaround;
import com.mikemilla.wordnerd.R;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        // Keyboard / Full screen Bug Fix
        AndroidBug5497Workaround.assistActivity(this);
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

}
