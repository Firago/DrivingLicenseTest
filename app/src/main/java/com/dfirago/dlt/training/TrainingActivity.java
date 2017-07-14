package com.dfirago.dlt.training;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dfirago.dlt.R;
import com.dfirago.dlt.question.data.QuestionRepository;
import com.dfirago.dlt.question.fragment.AbstractQuestionFragment;
import com.dfirago.dlt.question.fragment.factory.GenericQuestionFragmentFactory;
import com.dfirago.dlt.question.model.AbstractQuestion;
import com.dfirago.dlt.question.fragment.factory.ImageQuestionFragmentFactory;
import com.dfirago.dlt.question.model.ImageQuestion;
import com.dfirago.dlt.question.fragment.factory.SimpleQuestionFragmentFactory;
import com.dfirago.dlt.question.model.SimpleQuestion;
import com.dfirago.dlt.question.fragment.factory.VideoQuestionFragmentFactory;
import com.dfirago.dlt.question.model.VideoQuestion;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingActivity extends AppCompatActivity implements TrainingView,
        AbstractQuestionFragment.OnFragmentInteractionListener {

    private TrainingPresenter trainingPresenter;
    private GenericQuestionFragmentFactory fragmentFactory;

    public static Intent getIntent(Activity callingActivity) {
        return new Intent(callingActivity, TrainingActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        ButterKnife.bind(this);

        AssetManager assetManager = getAssets();
        QuestionRepository questionRepository = new QuestionRepository(assetManager);
        trainingPresenter = new TrainingPresenter(questionRepository);

        SimpleQuestionFragmentFactory simpleQuestionFragmentFactory = new SimpleQuestionFragmentFactory();
        ImageQuestionFragmentFactory imageQuestionFragmentFactory = new ImageQuestionFragmentFactory();
        VideoQuestionFragmentFactory videoQuestionFragmentFactory = new VideoQuestionFragmentFactory();

        fragmentFactory = GenericQuestionFragmentFactory.builder()
                .registerMapping(SimpleQuestion.class, simpleQuestionFragmentFactory)
                .registerMapping(ImageQuestion.class, imageQuestionFragmentFactory)
                .registerMapping(VideoQuestion.class, videoQuestionFragmentFactory)
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        trainingPresenter.attachView(this);
        trainingPresenter.startTraining();
    }

    @Override
    protected void onPause() {
        trainingPresenter.detachView();
        super.onPause();
    }

    @Override
    public void showQuestion(AbstractQuestion question) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.question_container, fragmentFactory.createFragment(question))
                .commit();
    }
}
