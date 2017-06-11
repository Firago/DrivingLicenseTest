package com.dfirago.dlt.dashboard.model;

import android.view.View;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class DashboardItem {

    private String title;
    private int iconResource;
    private String color;
    private View.OnClickListener onClickListener;

    public DashboardItem(String title, int iconResource,
                         String color, View.OnClickListener onClickListener) {
        this.title = title;
        this.iconResource = iconResource;
        this.color = color;
        this.onClickListener = onClickListener;
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

    public View.OnClickListener getOnItemClickListener() {
        return onClickListener;
    }
}
