package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.presenters.TrainingPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class TrainingFooterView extends AbstractFooterView {

    @BindView(R.id.button_previous)
    ImageButton buttonPrevious;
    @BindView(R.id.button_hint)
    ImageButton buttonHint;
    @BindView(R.id.button_next)
    ImageButton buttonNext;

    private TrainingPresenter trainingPresenter;

    @Inject
    public TrainingFooterView(Context context, TrainingPresenter trainingPresenter) {
        super(context);
        this.trainingPresenter = trainingPresenter;
        View.inflate(getContext(), R.layout.view_training_footer, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_previous)
    public void onPreviousClicked() {
        trainingPresenter.onPreviousClicked();
    }

    @OnClick(R.id.button_next)
    public void onNextClicked() {
        trainingPresenter.onNextClicked();
    }

    @OnClick(R.id.button_hint)
    public void onHintClicked() {
        trainingPresenter.onHintClicked();
    }
}
