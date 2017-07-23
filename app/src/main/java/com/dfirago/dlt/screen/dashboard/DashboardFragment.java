package com.dfirago.dlt.screen.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

public class DashboardFragment extends Fragment implements DashboardView {

    @Inject
    NavigationManager navigationManager;

    @Inject
    DashboardPresenter dashboardPresenter;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
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
        dashboardPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        dashboardPresenter.detachView();
        super.onPause();
    }

    @OnClick(R.id.item_category_a)
    public void chooseCategory_A(View view) {
        dashboardPresenter.onCategorySelected(Category.A);
    }

    @OnClick(R.id.item_category_b)
    public void chooseCategory_B(View view) {
        dashboardPresenter.onCategorySelected(Category.B);
    }

    @OnClick(R.id.item_category_c)
    public void chooseCategory_C(View view) {
        dashboardPresenter.onCategorySelected(Category.C);
    }

    @OnClick(R.id.item_category_d)
    public void chooseCategory_D(View view) {
        dashboardPresenter.onCategorySelected(Category.D);
    }

    @OnClick(R.id.item_category_t)
    public void chooseCategory_T(View view) {
        dashboardPresenter.onCategorySelected(Category.T);
    }

    @OnClick(R.id.item_rate_app)
    public void chooseRateApp() {
        dashboardPresenter.onRateApplicationSelected();
    }

    @Override
    public void showCategoryScreen(Category category) {
        navigationManager.showCategoryScreen(category);
    }

    @Override
    public void showRateApplicationScreen() {
        String packageName = getActivity().getPackageName();
        navigationManager.showRateApplicationScreen(packageName);
    }
}
