package com.dfirago.drivinglicensetest.navigation;

import com.dfirago.drivinglicensetest.common.model.CategoryType;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
public interface NavigationManager {

    void showDashboardScreen();

    void showCategoryScreen(CategoryType categoryType);

    void showRateApplicationScreen(String packageName);

    void showTrainingScreen(CategoryType categoryType);

    void showExamScreen(CategoryType categoryType);
}
