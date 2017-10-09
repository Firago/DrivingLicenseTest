package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.dfirago.dlt.R;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class SimpleQuestionView extends AbstractQuestionView {

    public SimpleQuestionView(Context context) {
        super(context);
    }

    public SimpleQuestionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleQuestionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SimpleQuestionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_simple_question, this);
    }
}
