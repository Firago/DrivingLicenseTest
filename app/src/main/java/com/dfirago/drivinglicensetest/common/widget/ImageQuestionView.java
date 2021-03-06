package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.dfirago.drivinglicensetest.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class ImageQuestionView extends AbstractQuestionView {

    @BindView(R.id.question_image)
    ImageView questionImageView;

    @Inject
    public ImageQuestionView(Context context) {
        super(context);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_image_question, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setQuestionImage(Uri uri) {
        questionImageView.setImageURI(uri);
    }
}
