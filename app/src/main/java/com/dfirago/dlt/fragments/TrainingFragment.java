package com.dfirago.dlt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.utils.ViewGroupUtils;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.utils.QuestionViewFactory;
import com.dfirago.dlt.presenters.TrainingPresenter;
import com.dfirago.dlt.views.TrainingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingFragment extends BaseFragment implements TrainingView {

    private static final String CATEGORY_PARAM = "category";

    private Category category;

    @BindView(R.id.question_view_container)
    LinearLayout questionViewContainer;

    @Inject
    TrainingPresenter trainingPresenter;
    @Inject
    QuestionViewFactory questionViewFactory;

    public static TrainingFragment newInstance(Category category) {
        TrainingFragment fragment = new TrainingFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_PARAM, category.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryArg = getArguments().getString(CATEGORY_PARAM);
            category = Category.valueOf(categoryArg);
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
        trainingPresenter.startTraining(category);
    }

    @Override
    public void showQuestion(AbstractQuestion question) {
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
