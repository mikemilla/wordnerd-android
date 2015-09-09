package com.mikemilla.wordnerd.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import com.mikemilla.wordnerd.AndroidBug5497Workaround;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.views.EightBitNominalEditText;

public class GameActivity extends Activity {

    EightBitNominalEditText rhymeEntry;
    Boolean isKeyboardOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        // Keyboard / Full screen Bug Fix
        fixFullscreenKeyboardBug(this);

        // Check keyboard status
        final View rootView = getWindow().getDecorView().findViewById(R.id.main);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
                isKeyboardOpen = heightDiff >= 150;
                android.util.Log.d("heightDiff", "" + heightDiff);
                android.util.Log.d("isKeyboardOpen", "" + isKeyboardOpen);

                if (isKeyboardOpen) {
                    findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.black));
                } else {
                    findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });

        // Main Content Area
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);
        main.setBackgroundColor(getResources().getColor(R.color.black));

        // Game Content Area
        RelativeLayout game = (RelativeLayout) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isKeyboardOpen) {
                    openKeyboard();
                }
            }
        });

        // Rhyme entry area and text change listener
        rhymeEntry = (EightBitNominalEditText) findViewById(R.id.rhyme_entry);
        rhymeEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String space = s.toString().replaceAll(" ", "");
                String back = s.toString().replaceAll("\\u003F", "");
                if (!s.toString().equals(space)) {
                    rhymeEntry.setText(space);
                    rhymeEntry.setSelection(space.length());
                }
                if (!s.toString().equals(back)) {
                    rhymeEntry.setText(back);
                    rhymeEntry.setSelection(back.length());
                }
            }
        });
    }

    public void fixFullscreenKeyboardBug(final Activity activity) {

        // Turn off Fullscreen mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Turn on Fullscreen mode
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                AndroidBug5497Workaround.assistActivity(activity);
            }
        }, 100);
    }

    public void openKeyboard() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(
                InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        rhymeEntry.requestFocus();
    }

    public void closeKeyboard() {
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(rhymeEntry.getWindowToken(), 0);
    }

    @Override
    public void onPause() {
        super.onPause();
        closeKeyboard();
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
