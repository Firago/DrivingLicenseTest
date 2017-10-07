package com.dfirago.dlt.screen.exam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by firag on 10/7/2017.
 */
public class ExamFragment extends Fragment implements ExamView {

    private static final String CATEGORY_PARAM = "category";

    @Inject
    NavigationManager navigationManager;
    @Inject
    ExamPresenter examPresenter;

    public static ExamFragment newInstance(Category category) {
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_PARAM, category.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryArg = getArguments().getString(CATEGORY_PARAM);
            Category category = Category.valueOf(categoryArg);
            examPresenter.loadQuestions(category);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        examPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        examPresenter.detachView();
        super.onPause();
    }

    @Override
    public void showQuestion(AbstractQuestion question) {
        // TODO custom views
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.question_container, fragmentFactory.createFragment(question))
//                .commit();
    }
}
