package com.dfirago.dlt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.navigation.impl.NavigationManagerImpl;
import com.dfirago.dlt.presenters.DashboardPresenter;
import com.dfirago.dlt.views.DashboardView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends BaseFragment implements DashboardView {

    @Inject
    NavigationManagerImpl navigationManager;
    @Inject
    DashboardPresenter dashboardPresenter;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.item_category_a)
    public void chooseCategory_A() {
        dashboardPresenter.onCategorySelected(Category.A);
    }

    @OnClick(R.id.item_category_b)
    public void chooseCategory_B() {
        dashboardPresenter.onCategorySelected(Category.B);
    }

    @OnClick(R.id.item_category_c)
    public void chooseCategory_C() {
        dashboardPresenter.onCategorySelected(Category.C);
    }

    @OnClick(R.id.item_category_d)
    public void chooseCategory_D() {
        dashboardPresenter.onCategorySelected(Category.D);
    }

    @OnClick(R.id.item_category_t)
    public void chooseCategory_T() {
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
