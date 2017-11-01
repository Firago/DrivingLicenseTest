package com.dfirago.drivinglicensetest.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.utils.StringUtils;
import com.dfirago.drivinglicensetest.common.utils.ViewGroupUtils;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.factories.QuestionViewFactory;
import com.dfirago.drivinglicensetest.database.dao.CategoryDao;
import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.database.model.types.ExamStats;
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

    private static final String TAG = "ExamFragment";
    private static final String CATEGORY_PARAM = "categoryType";

    private Category category;
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
    CategoryDao categoryDao;
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
            CategoryType categoryType = CategoryType.valueOf(categoryArg);
            category = categoryDao.findCategoryByType(categoryType);
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
        examPresenter.startExam(category);
    }

    @OnClick(R.id.button_next)
    public void onNextClicked() {
        examPresenter.onNextClicked();
    }

    @Override
    public void showQuestion(Question question) {
        Log.d(TAG, "Creating question view...");
        currentQuestionView = questionViewFactory
                .createView(question, questionContainer.getLayoutParams());
        currentQuestionView.setOptionSelectionChangeListener((option, isChecked) -> {
            if (isChecked) examPresenter.checkOption(option);
        });
        Log.d(TAG, "Replacing question view...");
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
