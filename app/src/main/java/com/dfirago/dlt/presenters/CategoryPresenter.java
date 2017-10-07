package com.dfirago.dlt.presenters;

import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.TestMode;
import com.dfirago.dlt.views.CategoryView;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 15/07/2017.
 */
public class CategoryPresenter {

    private CategoryView view;

    @Inject
    public CategoryPresenter(CategoryView view) {
        this.view = view;
    }

    public void onModeSelected(Category category, TestMode testMode) {
        if (testMode == TestMode.TRAINING) {
            view.showTrainingScreen(category);
        } else if (testMode == TestMode.EXAM) {
            view.showExamScreen(category);
        }
    }
}
