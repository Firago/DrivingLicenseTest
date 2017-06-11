package com.dfirago.dlt.dashboard.model;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class DashboardItem {

    private String title;
    private int drawable;
    private String color;

    public DashboardItem(String title, int drawable, String color) {
        this.title = title;
        this.drawable = drawable;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "DashboardItem{" +
                "title='" + title + '\'' +
                ", drawable=" + drawable +
                ", color='" + color + '\'' +
                '}';
    }
}
