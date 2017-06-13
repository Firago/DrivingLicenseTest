package com.dfirago.dlt.dashboard.data;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.model.DashboardItem;
import com.dfirago.dlt.dashboard.model.ItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Firago on 13/06/2017.
 */
public class DashboardRepository {

    private static final List<DashboardItem> DASHBOARD_ITEMS = new ArrayList<DashboardItem>() {{
        add(new DashboardItem(ItemType.CATEGORY_A, "Kategoria A",
                R.drawable.ic_motorcycle_white_48dp, "#09A9FF"));
        add(new DashboardItem(ItemType.CATEGORY_B, "Kategoria B",
                R.drawable.ic_directions_car_white_48dp, "#3E51B1"));
        add(new DashboardItem(ItemType.CATEGORY_C, "Kategoria C",
                R.drawable.ic_local_shipping_white_48dp, "#673BB7"));
        add(new DashboardItem(ItemType.CATEGORY_D, "Kategoria D",
                R.drawable.ic_directions_bus_white_48dp, "#4BAA50"));
        add(new DashboardItem(ItemType.CATEGORY_T, "Kategoria T",
                R.drawable.ic_help_outline_white_48dp, "#F94336")); // TODO icon
        add(new DashboardItem(ItemType.RATE, "Polub nas",
                R.drawable.ic_thumb_up_white_48dp, "#0A9B88"));
    }};

    private static final List<DashboardItem> CATEGORY_OPTIONS = new ArrayList<DashboardItem>() {{
        add(new DashboardItem(ItemType.TRAINING, "Nauka",
                R.drawable.ic_school_white_48dp, "#09A9FF"));
        add(new DashboardItem(ItemType.EXAM, "Egzamin",
                R.drawable.ic_assignment_white_48dp, "#3E51B1"));
    }};

    public List<DashboardItem> getDashboardItems() {
        return DASHBOARD_ITEMS;
    }

    public List<DashboardItem> getCategoryOptions() {
        return CATEGORY_OPTIONS;
    }
}
