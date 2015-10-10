package com.mikemilla.wordnerd.activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    private static final int ONE_SECOND = 1000;
    private static final int FINISH = 0;
    private static final int ONE_SECOND_IN_MILLISECOND = 1000;
    private Activity timerActivity;
    private int seconds;
    private Timer timer;
    private OnCountdownFinish onCountdownFinish;
    private ProgressBar progressBar;

    public CountdownTimer(Activity timerActivity, int seconds, ProgressBar progressBar) {
        this.timerActivity = timerActivity;
        this.seconds = seconds;
        this.progressBar = progressBar;
    }

    public void start() {
        if (timer == null && !isTimeReachedZero()) {
            startTimerAndScheduleTask();
        }
    }

    private void startTimerAndScheduleTask() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateProgressInUiThread();
            }
        };
        timer.schedule(task, 0, ONE_SECOND_IN_MILLISECOND);
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void updateProgressInUiThread() {
        timerActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateProgress();
            }
        });
    }

    private void updateProgress() {
        seconds -= ONE_SECOND;

        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", seconds);
        animation.setDuration(1000);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();
        progressBar.setProgress(seconds);

        if (isTimeReachedZero()) {
            callBackOnCountdownFinish();
            timer.cancel();
        }
    }

    private void callBackOnCountdownFinish() {
        if (onCountdownFinish != null) {
            onCountdownFinish.onCountdownFinish();
        }
    }

    private boolean isTimeReachedZero() {
        return seconds == FINISH;
    }

    public void setOnCountdownFinish(OnCountdownFinish onCountdownFinish) {
        this.onCountdownFinish = onCountdownFinish;
    }

}