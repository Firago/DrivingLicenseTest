package com.dfirago.dlt.dashboard.model;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class DashboardItem {

    private ItemType itemType;
    private String title;
    private int iconResource;
    private String color;

    public DashboardItem(ItemType itemType, String title, int iconResource, String color) {
        this.itemType = itemType;
        this.title = title;
        this.iconResource = iconResource;
        this.color = color;
    }

    public ItemType getItemType() {
        return itemType;
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
