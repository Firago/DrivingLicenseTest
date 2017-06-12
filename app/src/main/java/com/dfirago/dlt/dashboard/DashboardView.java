package com.dfirago.dlt.dashboard;

import com.dfirago.dlt.dashboard.model.DashboardItem;

import java.util.List;

/**
 * Created by Dmytro Firago on 10/06/2017.
 */
public interface DashboardView {

    void showItems(List<DashboardItem> items);

    void onCategoryItemClicked();

    void onTrainingItemClicked();

    void onExamItemClicked();

    void onRateItemClicked();
}
