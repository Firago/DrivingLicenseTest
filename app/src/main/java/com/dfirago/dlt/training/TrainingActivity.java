package com.dfirago.dlt.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dfirago.dlt.R;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingActivity extends AppCompatActivity implements TrainingView {

    private TrainingPresenter trainingPresenter;

    public static Intent getIntent(Activity callingActivity) {
        return new Intent(callingActivity, TrainingActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        ButterKnife.bind(this);

        trainingPresenter = new TrainingPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        trainingPresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        trainingPresenter.detachView();
        super.onPause();
    }
}
