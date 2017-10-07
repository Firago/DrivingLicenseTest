package com.dfirago.dlt.presenters;

import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.views.DashboardView;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 14/07/2017.
 */
public class DashboardPresenter {

    private DashboardView view;

    @Inject
    public DashboardPresenter(DashboardView view) {
        this.view = view;
    }

    public void onCategorySelected(Category category) {
        view.showCategoryScreen(category);
    }

    public void onRateApplicationSelected() {
        view.showRateApplicationScreen();
    }
}
