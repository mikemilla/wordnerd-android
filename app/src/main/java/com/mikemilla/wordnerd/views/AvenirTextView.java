package com.mikemilla.wordnerd.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class AvenirTextView extends TextView {

    private Animation fadeIn;

    public AvenirTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AvenirTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AvenirTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenirNextLTPro-Demi.ttf");
            setTypeface(tf);
        }
        fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(200);
    }

    public void fadeText() {
        this.startAnimation(fadeIn);
    }

}

