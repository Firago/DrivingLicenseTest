package com.dfirago.dlt.dashboard;

import com.dfirago.dlt.BasePresenter;
import com.dfirago.dlt.dashboard.model.DashboardItem;

import java.util.Arrays;

/**
 * Created by Dmytro Firago on 10/06/2017.
 */
public class DashboardPresenter extends BasePresenter<DashboardView> {

    @Override
    protected Class viewClass() {
        return DashboardView.class;
    }

    public void loadDashboard() {
        view().showDashboard(Arrays.asList(DashboardItem.values()));
    }
}
