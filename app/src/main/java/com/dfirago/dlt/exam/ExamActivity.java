package com.dfirago.dlt.exam;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dfirago.dlt.R;
import com.dfirago.dlt.question.common.data.QuestionRepository;
import com.dfirago.dlt.question.common.fragment.AbstractQuestionFragment;
import com.dfirago.dlt.question.common.fragment.GenericQuestionFragmentFactory;
import com.dfirago.dlt.question.common.model.AbstractQuestion;
import com.dfirago.dlt.question.image.fragment.ImageQuestionFragmentFactory;
import com.dfirago.dlt.question.image.model.ImageQuestion;
import com.dfirago.dlt.question.simple.fragment.SimpleQuestionFragmentFactory;
import com.dfirago.dlt.question.simple.model.SimpleQuestion;
import com.dfirago.dlt.question.video.fragment.VideoQuestionFragmentFactory;
import com.dfirago.dlt.question.video.model.VideoQuestion;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class ExamActivity extends AppCompatActivity implements ExamView,
        AbstractQuestionFragment.OnFragmentInteractionListener {

    private ExamPresenter examPresenter;
    private GenericQuestionFragmentFactory fragmentFactory;

    public static Intent getIntent(Activity callingActivity) {
        return new Intent(callingActivity, ExamActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        ButterKnife.bind(this);

        AssetManager assetManager = getAssets();
        QuestionRepository questionRepository = new QuestionRepository(assetManager);
        examPresenter = new ExamPresenter(questionRepository);

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
        examPresenter.attachView(this);
        examPresenter.startExam();
    }

    @Override
    protected void onPause() {
        examPresenter.detachView();
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
