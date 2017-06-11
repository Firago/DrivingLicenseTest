package com.dfirago.dlt.dashboard;

import com.dfirago.dlt.BasePresenter;
import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.model.DashboardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Firago on 10/06/2017.
 */
public class DashboardPresenter extends BasePresenter<DashboardView> {

    @Override
    protected Class viewClass() {
        return DashboardView.class;
    }

    public void loadDashboard() {
        final List<DashboardItem> items = new ArrayList<>();
        items.add(new DashboardItem("Nauka", R.drawable.ic_school_white_48dp, "#09A9FF"));
        items.add(new DashboardItem("Egzamin", R.drawable.ic_assignment_white_48dp, "#3E51B1"));
        items.add(new DashboardItem("O nas", R.drawable.ic_help_outline_white_48dp, "#673BB7"));
        items.add(new DashboardItem("Polub nas", R.drawable.ic_thumb_up_white_48dp, "#4BAA50"));
        view().showDashboard(items);
    }
}
