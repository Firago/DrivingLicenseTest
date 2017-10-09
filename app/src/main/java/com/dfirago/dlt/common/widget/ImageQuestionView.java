package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.dfirago.dlt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class ImageQuestionView extends AbstractQuestionView {

    @BindView(R.id.question_image)
    ImageView questionImageView;

    public ImageQuestionView(Context context) {
        super(context);
    }

    public ImageQuestionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageQuestionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ImageQuestionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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

    public void setQuestionImage(Drawable drawable) {
        questionImageView.setImageDrawable(drawable);
    }
}
