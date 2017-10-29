package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.view.View;

import com.dfirago.drivinglicensetest.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class SimpleQuestionView extends AbstractQuestionView {

    @Inject
    public SimpleQuestionView(Context context) {
        super(context);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_simple_question, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
