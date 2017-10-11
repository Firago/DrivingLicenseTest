package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.view.View;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.widget.utils.OptionsAdapter;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class SimpleQuestionView extends AbstractQuestionView {

    @Inject
    public SimpleQuestionView(Context context, OptionsAdapter optionsAdapter) {
        super(context, optionsAdapter);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_simple_question, this);
    }
}
