package com.dfirago.dlt.navigation;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import com.dfirago.dlt.fragment.factory.GenericQuestionFragmentFactory;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.TestMode;
import com.dfirago.dlt.screen.category.CategoryFragment;
import com.dfirago.dlt.screen.dashboard.DashboardFragment;
import com.dfirago.dlt.screen.training.TrainingFragment;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 16/07/2017.
 */
public class NavigationManager {

    @Inject
    FragmentOrchestrator fragmentOrchestrator;

    @Inject
    GenericQuestionFragmentFactory questionFragmentFactory;

    public void attach(FragmentOrchestrator fragmentOrchestrator) {
        this.fragmentOrchestrator = fragmentOrchestrator;
    }

    public void detach() {
        this.fragmentOrchestrator = null;
    }

    public void showDashboardScreen() {
        DashboardFragment dashboardFragment = DashboardFragment.newInstance();
        fragmentOrchestrator.setContent(dashboardFragment);
    }

    public void showCategoryScreen(Category category) {
        CategoryFragment categoryFragment = CategoryFragment.newInstance(category);
        fragmentOrchestrator.setContent(categoryFragment);
    }

    public void showRateApplicationScreen(String packageName) {
        try {
            Uri uri = Uri.parse("market://details?id=" + packageName);
            fragmentOrchestrator.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName);
            fragmentOrchestrator.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }

    public void showTrainingScreen(Category category, TestMode testMode) {
        TrainingFragment trainingFragment = TrainingFragment.newInstance(category, testMode);
        fragmentOrchestrator.setContent(trainingFragment);
    }
}
