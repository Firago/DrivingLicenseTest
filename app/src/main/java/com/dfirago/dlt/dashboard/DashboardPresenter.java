package com.dfirago.dlt.dashboard;

import com.dfirago.dlt.BasePresenter;
import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.model.DashboardItem;
import com.dfirago.dlt.dashboard.model.ItemType;

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
        List<DashboardItem> items = new ArrayList<>();
        items.add(new DashboardItem(ItemType.CATEGORY_A, "Kategoria A", R.drawable.ic_motorcycle_white_48dp, "#09A9FF"));
        items.add(new DashboardItem(ItemType.CATEGORY_B, "Kategoria B", R.drawable.ic_directions_car_white_48dp, "#3E51B1"));
        items.add(new DashboardItem(ItemType.CATEGORY_B, "Kategoria C", R.drawable.ic_local_shipping_white_48dp, "#673BB7"));
        items.add(new DashboardItem(ItemType.CATEGORY_B, "Kategoria D", R.drawable.ic_directions_bus_white_48dp, "#4BAA50"));
        items.add(new DashboardItem(ItemType.CATEGORY_B, "Kategoria T", R.drawable.ic_help_outline_white_48dp, "#F94336")); // TODO icon
        items.add(new DashboardItem(ItemType.RATE, "Polub nas", R.drawable.ic_thumb_up_white_48dp, "#0A9B88"));
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

    public void loadCategoryOptions() {
        List<DashboardItem> items = new ArrayList<>();
        items.add(new DashboardItem(ItemType.TRAINING, "Nauka", R.drawable.ic_school_white_48dp, "#09A9FF"));
        items.add(new DashboardItem(ItemType.EXAM, "Egzamin", R.drawable.ic_assignment_white_48dp, "#3E51B1"));
        view().showItems(items);
    }
}
