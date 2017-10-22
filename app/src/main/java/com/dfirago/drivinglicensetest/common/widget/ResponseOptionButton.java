package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.dfirago.drivinglicensetest.R;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/22/2017.
 */
public class ResponseOptionButton extends AppCompatRadioButton {

    private static final int[] STATE_VALIDATED = {R.attr.state_validated};
    private static final int[] STATE_CORRECT = {R.attr.state_correct};

    private boolean validated;
    private boolean correct;

    public ResponseOptionButton(Context context) {
        super(context);
    }

    public ResponseOptionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResponseOptionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (validated) {
            mergeDrawableStates(drawableState, STATE_VALIDATED);
        }
        if (correct) {
            mergeDrawableStates(drawableState, STATE_CORRECT);
        }
        return drawableState;
    }

    public void setValidated(boolean validated) {
        if (this.validated != validated) {
            this.validated = validated;
            refreshDrawableState();
        }
    }

    public void setCorrect(boolean correct) {
        if (this.correct != correct) {
            this.correct = correct;
            refreshDrawableState();
        }
    }

    public void reset() {
        setValidated(false);
        setCorrect(false);
    }
}
