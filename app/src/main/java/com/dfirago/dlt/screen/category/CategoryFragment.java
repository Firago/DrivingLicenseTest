package com.dfirago.dlt.screen.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.TestMode;
import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends Fragment implements CategoryView {

    private static final String ARG_CATEGORY = "category_type";

    private Category category;

    @Inject
    NavigationManager navigationManager;

    @Inject
    CategoryPresenter categoryPresenter;

    public static CategoryFragment newInstance(Category category) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryArg = getArguments().getString(ARG_CATEGORY);
            category = Category.valueOf(categoryArg);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        categoryPresenter = new CategoryPresenter();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        categoryPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        categoryPresenter.detachView();
        super.onPause();
    }

    @OnClick(R.id.item_training)
    public void onTrainingItemClicked(View view) {
        categoryPresenter.onModeSelected(category, TestMode.TRAINING);
    }

    @OnClick(R.id.item_exam)
    public void onExamItemClicked(View view) {
        categoryPresenter.onModeSelected(category, TestMode.EXAM);
    }

    @Override
    public void showTrainingScreen(Category category, TestMode testMode) {
        navigationManager.showTrainingScreen(category, testMode);
    }
}
