package com.dfirago.dlt.screen.training;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.TestMode;
import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingFragment extends Fragment implements TrainingView {

    @Inject
    NavigationManager navigationManager;

    @Inject
    TrainingPresenter trainingPresenter;

    public static TrainingFragment newInstance(Category category, TestMode testMode) {
        TrainingFragment fragment = new TrainingFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_CATEGORY, category.name());
//        args.putString(ARG_TEST_MODE, testMode.name());
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            String categoryArg = getArguments().getString(ARG_CATEGORY);
//            category = Category.valueOf(categoryArg);
//            String testModeArg = getArguments().getString(ARG_TEST_MODE);
//            testMode = Category.valueOf(testModeArg);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showQuestion(AbstractQuestion question) {
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.question_container, fragmentFactory.createFragment(question))
//                .commit();
    }
}
