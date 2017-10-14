package com.dfirago.drivinglicensetest.views;

import com.dfirago.drivinglicensetest.common.model.CategoryType;

/**
 * Created by Dmytro Firago on 16/07/2017.
 */
public interface DashboardView {

    void showCategoryScreen(CategoryType categoryType);

    void showRateApplicationScreen();

    void onSetupStarted();

    void onSetupFinished();

    void onSetupSuccess();

    void onSetupError();
}
