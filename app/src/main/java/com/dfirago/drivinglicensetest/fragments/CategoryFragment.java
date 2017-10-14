package com.dfirago.drivinglicensetest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.TestMode;
import com.dfirago.drivinglicensetest.navigation.impl.NavigationManagerImpl;
import com.dfirago.drivinglicensetest.presenters.CategoryPresenter;
import com.dfirago.drivinglicensetest.views.CategoryView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends BaseFragment implements CategoryView {

    private static final String ARG_CATEGORY = "category_type";

    private CategoryType categoryType;

    @Inject
    NavigationManagerImpl navigationManager;
    @Inject
    CategoryPresenter categoryPresenter;

    public static CategoryFragment newInstance(CategoryType categoryType) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, categoryType.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryArg = getArguments().getString(ARG_CATEGORY);
            categoryType = CategoryType.valueOf(categoryArg);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.item_training)
    public void onTrainingItemClicked() {
        categoryPresenter.onModeSelected(categoryType, TestMode.TRAINING);
    }

    @OnClick(R.id.item_exam)
    public void onExamItemClicked() {
        categoryPresenter.onModeSelected(categoryType, TestMode.EXAM);
    }

    @Override
    public void showTrainingScreen(CategoryType categoryType) {
        navigationManager.showTrainingScreen(categoryType);
    }

    @Override
    public void showExamScreen(CategoryType categoryType) {
        navigationManager.showExamScreen(categoryType);
    }
}
