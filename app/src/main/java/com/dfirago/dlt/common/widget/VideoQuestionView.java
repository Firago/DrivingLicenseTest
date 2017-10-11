package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.view.View;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.widget.utils.OptionsAdapter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class VideoQuestionView extends AbstractQuestionView {

    @Inject
    public VideoQuestionView(Context context, OptionsAdapter optionsAdapter) {
        super(context, optionsAdapter);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_video_question, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
