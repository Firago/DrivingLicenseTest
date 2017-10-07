package com.dfirago.dlt.navigation;

import com.dfirago.dlt.common.model.Category;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
public interface NavigationManager {

    void showDashboardScreen();

    void showCategoryScreen(Category category);

    void showRateApplicationScreen(String packageName);

    void showTrainingScreen(Category category);

    void showExamScreen(Category category);
}
