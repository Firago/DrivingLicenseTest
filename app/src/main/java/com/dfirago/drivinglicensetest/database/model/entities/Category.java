package com.dfirago.drivinglicensetest.database.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private CategoryType categoryType;

    public Category() {

    }

    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
