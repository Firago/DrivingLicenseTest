package com.dfirago.drivinglicensetest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.ExamStats;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.utils.StringUtils;
import com.dfirago.drivinglicensetest.common.utils.ViewGroupUtils;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.factories.QuestionViewFactory;
import com.dfirago.drivinglicensetest.presenters.ExamPresenter;
import com.dfirago.drivinglicensetest.views.ExamView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by firag on 10/7/2017.
 */
public class ExamFragment extends BaseFragment implements ExamView {

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
    @BindView(R.id.total_timer_value)
    TextView totalTimerValueView;
    @BindView(R.id.question_timer_title)
    TextView questionTimerTitleView;
    @BindView(R.id.question_timer_value)
    TextView questionTimerValueView;

    @Inject
    ExamPresenter examPresenter;
    @Inject
    QuestionViewFactory questionViewFactory;

    public static ExamFragment newInstance(CategoryType categoryType) {
        ExamFragment fragment = new ExamFragment();
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
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        examPresenter.startExam(categoryType);
    }

    @OnClick(R.id.button_next)
    public void onNextClicked() {
        examPresenter.onNextClicked();
    }

    @Override
    public void showQuestion(Question question) {
        currentQuestionView = questionViewFactory
                .createView(question, questionContainer.getLayoutParams());
        ViewGroupUtils.replaceView(questionContainer, currentQuestionView);
        questionContainer = currentQuestionView;
        questionPointsView.setText(String.valueOf(question.getPoints()));
    }

    @Override
    public void updateQuestionNumber(int current, int total) {
        currentQuestionNumberView.setText(String.valueOf(current));
        totalQuestionNumberView.setText(String.valueOf(total));
    }

    @Override
    public void updateTotalTimer(long timeLeftMillis) {
        totalTimerValueView.setText(StringUtils.millisToTimeString(timeLeftMillis));
    }

    @Override
    public void updateQuestionTimer(long millisUntilFinished) {
        questionTimerValueView.setText(StringUtils.millisToTimeString(millisUntilFinished));
    }

    @Override
    public void showResults(ExamStats examStats) {
        int score = examStats.getScore();
        int totalPoints = examStats.getTotalPoints();
        Toast.makeText(getContext(), "Wynik: " + score + "/" + totalPoints, Toast.LENGTH_LONG).show();
    }
}
