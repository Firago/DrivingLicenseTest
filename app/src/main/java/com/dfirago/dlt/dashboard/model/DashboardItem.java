package com.dfirago.dlt.dashboard.model;

import com.dfirago.dlt.R;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public enum DashboardItem {

    TRAINING("Nauka", R.drawable.ic_school_white_48dp, "#09A9FF"),
    EXAM("Egzamin", R.drawable.ic_assignment_white_48dp, "#3E51B1"),
    ABOUT_US("O nas", R.drawable.ic_help_outline_white_48dp, "#673BB7"),
    RATE_US("Polub nas", R.drawable.ic_thumb_up_white_48dp, "#4BAA50");

    private String title;
    private int iconResource;
    private String color;

    DashboardItem(String title, int iconResource, String color) {
        this.title = title;
        this.iconResource = iconResource;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getIconResource() {
        return iconResource;
    }

    public String getColor() {
        return color;
    }
}
