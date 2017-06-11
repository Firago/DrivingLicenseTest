package com.dfirago.dlt.dashboard;

import com.dfirago.dlt.BasePresenter;

/**
 * Created by Dmytro Firago on 10/06/2017.
 */
public class DashboardPresenter extends BasePresenter<DashboardView> {

    @Override
    protected Class viewClass() {
        return DashboardView.class;
    }
}
