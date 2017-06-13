package com.dfirago.dlt.dashboard;

import com.dfirago.dlt.BasePresenter;
import com.dfirago.dlt.dashboard.data.DashboardRepository;
import com.dfirago.dlt.dashboard.model.DashboardItem;

import java.util.List;

/**
 * Created by Dmytro Firago on 10/06/2017.
 */
public class DashboardPresenter extends BasePresenter<DashboardView> {

    private final DashboardRepository dashboardRepository;

    public DashboardPresenter(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    @Override
    protected Class viewClass() {
        return DashboardView.class;
    }

    public void loadDashboard() {
        final List<DashboardItem> items = dashboardRepository.getDashboardItems();
        view().showItems(items);
    }

    public void loadCategoryOptions() {
        final List<DashboardItem> items = dashboardRepository.getCategoryOptions();
        view().showItems(items);
    }

    public void onItemClicked(DashboardItem item) {
        switch (item.getItemType()) {
            case CATEGORY_A:
            case CATEGORY_B:
            case CATEGORY_C:
            case CATEGORY_D:
            case CATEGORY_T:
                view().onCategoryItemClicked();
                break;
            case TRAINING:
                view().onTrainingItemClicked();
                break;
            case EXAM:
                view().onExamItemClicked();
                break;
            case RATE:
                view().onRateItemClicked();
                break;
        }
    }
}
