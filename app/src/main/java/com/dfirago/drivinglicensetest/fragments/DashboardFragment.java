package com.dfirago.drivinglicensetest.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.navigation.impl.NavigationManagerImpl;
import com.dfirago.drivinglicensetest.presenters.DashboardPresenter;
import com.dfirago.drivinglicensetest.views.DashboardView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends BaseFragment implements DashboardView {

    private final static String TAG = "DashboardFragment";

    private ProgressDialog progressDialog;

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

    @Override
    public void onResume() {
        super.onResume();
        dashboardPresenter.performSetupIfNeeded();
    }

    @Override
    public void showCategoryScreen(CategoryType categoryType) {
        navigationManager.showCategoryScreen(categoryType);
    }

    @Override
    public void showRateApplicationScreen() {
        String packageName = getActivity().getPackageName();
        navigationManager.showRateApplicationScreen(packageName);
    }

    @Override
    public void onSetupStarted() {
        Log.i(TAG, "Setup process started");
        progressDialog = ProgressDialog.show(getActivity(), "Loading", "Setting up the application");
    }

    @Override
    public void onSetupFinished() {
        Log.i(TAG, "Setup process finished");
        progressDialog.dismiss();
    }

    @Override
    public void onSetupSuccess() {
        Toast.makeText(getActivity(), "Setup completed successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetupError(Throwable t) {
        Log.e(TAG, "Setup failed", t);
        Toast.makeText(getActivity(), "Failed to setup application", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.item_category_a)
    public void chooseCategory_A() {
        dashboardPresenter.onCategorySelected(CategoryType.A);
    }

    @OnClick(R.id.item_category_b)
    public void chooseCategory_B() {
        dashboardPresenter.onCategorySelected(CategoryType.B);
    }

    @OnClick(R.id.item_category_c)
    public void chooseCategory_C() {
        dashboardPresenter.onCategorySelected(CategoryType.C);
    }

    @OnClick(R.id.item_category_d)
    public void chooseCategory_D() {
        dashboardPresenter.onCategorySelected(CategoryType.D);
    }

    @OnClick(R.id.item_category_t)
    public void chooseCategory_T() {
        dashboardPresenter.onCategorySelected(CategoryType.T);
    }

    @OnClick(R.id.item_rate_app)
    public void chooseRateApp() {
        dashboardPresenter.onRateApplicationSelected();
    }

}
