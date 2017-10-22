package com.dfirago.drivinglicensetest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.utils.ViewGroupUtils;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.factories.QuestionViewFactory;
import com.dfirago.drivinglicensetest.fragments.listeners.TrainingOptionSelectionChangeListener;
import com.dfirago.drivinglicensetest.presenters.TrainingPresenter;
import com.dfirago.drivinglicensetest.views.TrainingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingFragment extends BaseFragment implements TrainingView {

    private static final String CATEGORY_PARAM = "categoryType";

    private CategoryType categoryType;
    private AbstractQuestionView currentQuestionView;

    @BindView(R.id.question_container)
    View questionContainer;
    @BindView(R.id.questions_current)
    TextView currentQuestionNumberView;
    @BindView(R.id.questions_total)
    TextView totalQuestionNumberView;
    @BindView(R.id.question_points)
    TextView questionPointsView;

    @Inject
    TrainingPresenter trainingPresenter;
    @Inject
    QuestionViewFactory questionViewFactory;

    public static TrainingFragment newInstance(CategoryType categoryType) {
        TrainingFragment fragment = new TrainingFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_PARAM, categoryType.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryArg = getArguments().getString(CATEGORY_PARAM);
            categoryType = CategoryType.valueOf(categoryArg);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        trainingPresenter.startTraining(categoryType);
    }

    @Override
    public void showQuestion(Question question) {
        currentQuestionView = questionViewFactory
                .createView(question, questionContainer.getLayoutParams());
        currentQuestionView.setOptionSelectionChangeListener(
                new TrainingOptionSelectionChangeListener(currentQuestionView));
        ViewGroupUtils.replaceView(questionContainer, currentQuestionView);
        questionContainer = currentQuestionView;
        questionPointsView.setText(String.valueOf(question.getPoints()));
    }

    @Override
    public void showAnswer() {
        currentQuestionView.showAnswer();
    }

    @Override
    public void updateQuestionNumber(int current, int total) {
        currentQuestionNumberView.setText(String.valueOf(current));
        totalQuestionNumberView.setText(String.valueOf(total));
    }

    @OnClick(R.id.button_previous)
    public void onPreviousClicked() {
        trainingPresenter.onPreviousClicked();
    }

    @OnClick(R.id.button_hint)
    public void onHintClicked() {
        trainingPresenter.onHintClicked();
    }

    @OnClick(R.id.button_next)
    public void onNextClicked() {
        trainingPresenter.onNextClicked();
    }
}
