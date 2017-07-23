package com.dfirago.dlt.screen.dashboard;

import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.navigation.BasePresenter;

/**
 * Created by Dmytro Firago on 14/07/2017.
 */
public class DashboardPresenter extends BasePresenter<DashboardView> {

    public void onCategorySelected(Category category) {
        view().showCategoryScreen(category);
    }

    public void onRateApplicationSelected() {
        view().showRateApplicationScreen();
    }

    @Override
    protected Class viewClass() {
        return DashboardView.class;
    }
}
