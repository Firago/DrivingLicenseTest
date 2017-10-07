package com.dfirago.dlt.screen.category;

import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.TestMode;
import com.dfirago.dlt.navigation.BasePresenter;

/**
 * Created by Dmytro Firago on 15/07/2017.
 */
public class CategoryPresenter extends BasePresenter<CategoryView> {

    @Override
    protected Class viewClass() {
        return CategoryView.class;
    }

    public void onModeSelected(Category category, TestMode testMode) {
        if (testMode == TestMode.TRAINING) {
            view().showTrainingScreen(category);
        } else if (testMode == TestMode.EXAM) {
            view().showExamScreen(category);
        }
    }
}
