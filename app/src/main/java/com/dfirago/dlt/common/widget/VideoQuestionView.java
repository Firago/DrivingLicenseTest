package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.view.View;

import com.dfirago.dlt.R;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class VideoQuestionView extends AbstractQuestionView {

    public VideoQuestionView(Context context) {
        super(context);
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
