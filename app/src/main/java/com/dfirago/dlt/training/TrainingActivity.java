package com.dfirago.dlt.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dfirago.dlt.R;
import com.dfirago.dlt.training.model.Option;
import com.dfirago.dlt.training.model.SimpleQuestion;

import java.util.Arrays;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingActivity extends AppCompatActivity
        implements TrainingView, QuestionFragment.OnFragmentInteractionListener {

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

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.question_container, SimpleQuestionFragment
                        .newInstance(new SimpleQuestion("Do you want to kakamaliaka?",
                                Arrays.asList(
                                        new Option("biak", true),
                                        new Option("biak!", false)
                                ))
                        )
                ).commit();
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
