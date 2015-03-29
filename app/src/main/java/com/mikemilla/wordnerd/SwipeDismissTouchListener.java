package com.mikemilla.wordnerd;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SwipeDismissTouchListener implements View.OnTouchListener {

    static final String logTag = "ActivitySwipeDetector";
    static final int MIN_DISTANCE = 100;// TODO change this runtime based on screen resolution. for 1920x1080 is to small the 100 distance
    private float downX, upX;

    public SwipeDismissTouchListener(Activity gameActivity) {
        Activity activity = gameActivity;
    }

    public void onRightToLeftSwipe() {
        if (GameActivity.userRhyme.getText().length() > 0) {
            GameActivity.userRhyme.startAnimation(GameActivity.slideLeft);
            clear();
        }
    }

    public void onLeftToRightSwipe() {
        if (GameActivity.userRhyme.getText().length() > 0) {
            GameActivity.userRhyme.startAnimation(GameActivity.slideRight);
            clear();
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                downX = event.getX();
                return true;
            }
            case MotionEvent.ACTION_UP: {
                upX = event.getX();

                float deltaX = downX - upX;

                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (deltaX < 0) {
                        this.onLeftToRightSwipe();
                        return true;
                    }
                    if (deltaX > 0) {
                        this.onRightToLeftSwipe();
                        return true;
                    }
                } else {
                    Log.i(logTag, "Swipe was only " + Math.abs(deltaX) + " long horizontally, need at least " + MIN_DISTANCE);
                    // return false; // We don't consume the event
                }

                return false; // no swipe horizontally and no swipe vertically
            }// case MotionEvent.ACTION_UP:
        }
        return false;
    }

    public void clear() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                GameActivity.userRhyme.setText("");
            }
        }, 300);
    }
}