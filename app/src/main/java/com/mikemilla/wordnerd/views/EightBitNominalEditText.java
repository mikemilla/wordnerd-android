package com.mikemilla.wordnerd.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;

public class EightBitNominalEditText extends EditText {

    private Animation fadeIn;

    public EightBitNominalEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EightBitNominalEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EightBitNominalEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/8BITWONDERNominal.ttf");
            setTypeface(tf);
        }
        fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(200);
    }

    public void fadeText() {
        this.startAnimation(fadeIn);
    }

}

