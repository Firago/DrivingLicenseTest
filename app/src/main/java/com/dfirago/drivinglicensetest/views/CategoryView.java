package com.dfirago.drivinglicensetest.views;

import com.dfirago.drivinglicensetest.common.model.CategoryType;

/**
 * Created by Dmytro Firago on 16/07/2017.
 */
public interface CategoryView {

    void showTrainingScreen(CategoryType categoryType);

    void showExamScreen(CategoryType categoryType);
}
