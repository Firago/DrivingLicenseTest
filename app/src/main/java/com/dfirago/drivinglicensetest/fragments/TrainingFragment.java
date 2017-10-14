package com.dfirago.drivinglicensetest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.utils.ViewGroupUtils;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.factories.QuestionViewFactory;
import com.dfirago.drivinglicensetest.presenters.TrainingPresenter;
import com.dfirago.drivinglicensetest.views.TrainingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingFragment extends BaseFragment implements TrainingView {

    private static final String CATEGORY_PARAM = "categoryType";

    private CategoryType categoryType;

    @BindView(R.id.question_view_container)
    LinearLayout questionViewContainer;

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
        AbstractQuestionView view = questionViewFactory.createView(question);
        // TODO remove logic from the view
        view.setOptionSelectionChangeListener((option, isChecked) -> {
            if (isChecked) {
                view.highlight(option);
            } else {
                view.unhighlight(option);
            }
        });
        ViewGroupUtils.replaceView(questionViewContainer, view);
    }
}
