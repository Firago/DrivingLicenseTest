package com.dfirago.drivinglicensetest.presenters;

import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.database.model.enums.TestMode;
import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.views.CategoryView;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 15/07/2017.
 */
@FragmentScope
public class CategoryPresenter {

    private CategoryView view;

    @Inject
    public CategoryPresenter(CategoryView view) {
        this.view = view;
    }

    public void onModeSelected(CategoryType categoryType, TestMode testMode) {
        if (testMode == TestMode.TRAINING) {
            view.showTrainingScreen(categoryType);
        } else if (testMode == TestMode.EXAM) {
            view.showExamScreen(categoryType);
        }
    }
}
