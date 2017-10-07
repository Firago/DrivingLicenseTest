package com.dfirago.dlt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.fragments.questions.AbstractQuestionFragment;
import com.dfirago.dlt.fragments.questions.factory.QuestionFragmentFactory;
import com.dfirago.dlt.navigation.FragmentOrchestrator;
import com.dfirago.dlt.presenters.TrainingPresenter;
import com.dfirago.dlt.views.TrainingView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingFragment extends BaseFragment implements TrainingView {

    private static final String CATEGORY_PARAM = "category";

    @Inject
    TrainingPresenter trainingPresenter;
    @Inject
    FragmentOrchestrator fragmentOrchestrator;
    @Inject
    QuestionFragmentFactory questionFragmentFactory;

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
            Category category = Category.valueOf(categoryArg);
            trainingPresenter.startTraining(category);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showQuestion(AbstractQuestion question) {
        // TODO custom views
        AbstractQuestionFragment fragment = questionFragmentFactory.createFragment(question);
        fragmentOrchestrator.showFragment(fragment);
    }
}
