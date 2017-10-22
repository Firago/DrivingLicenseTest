package com.dfirago.drivinglicensetest.common.database.impl;

import com.dfirago.drivinglicensetest.common.database.CategoryService;
import com.dfirago.drivinglicensetest.common.model.Category;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class CategoryServiceImpl implements CategoryService {

    private Box<Category> categoryBox;

    @Inject
    public CategoryServiceImpl(BoxStore boxStore) {
        this.categoryBox = boxStore.boxFor(Category.class);
    }

    @Override
    public void removeAll() {
        categoryBox.removeAll();
    }
}
