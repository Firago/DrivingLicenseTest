package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.view.View;

import com.dfirago.dlt.R;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class SimpleQuestionView extends AbstractQuestionView {

    public SimpleQuestionView(Context context) {
        super(context);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_simple_question, this);
    }
}
