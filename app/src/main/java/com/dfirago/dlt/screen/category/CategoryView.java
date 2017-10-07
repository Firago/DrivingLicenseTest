package com.dfirago.dlt.screen.category;

import com.dfirago.dlt.common.model.Category;

/**
 * Created by Dmytro Firago on 16/07/2017.
 */
public interface CategoryView {

    void showTrainingScreen(Category category);

    void showExamScreen(Category category);
}
