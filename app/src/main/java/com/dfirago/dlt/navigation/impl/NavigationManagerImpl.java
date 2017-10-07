package com.dfirago.dlt.navigation.impl;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.fragments.CategoryFragment;
import com.dfirago.dlt.fragments.DashboardFragment;
import com.dfirago.dlt.fragments.ExamFragment;
import com.dfirago.dlt.fragments.TrainingFragment;
import com.dfirago.dlt.navigation.FragmentOrchestrator;
import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 16/07/2017.
 */
public class NavigationManagerImpl implements NavigationManager {

    private FragmentOrchestrator fragmentOrchestrator;

    @Inject
    public NavigationManagerImpl(FragmentOrchestrator fragmentOrchestrator) {
        this.fragmentOrchestrator = fragmentOrchestrator;
    }

    @Override
    public void showDashboardScreen() {
        DashboardFragment dashboardFragment = DashboardFragment.newInstance();
        fragmentOrchestrator.showFragment(dashboardFragment);
    }

    @Override
    public void showCategoryScreen(Category category) {
        CategoryFragment categoryFragment = CategoryFragment.newInstance(category);
        fragmentOrchestrator.showFragment(categoryFragment);
    }

    @Override
    public void showRateApplicationScreen(String packageName) {
        try {
            Uri uri = Uri.parse("market://details?id=" + packageName);
            fragmentOrchestrator.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName);
            fragmentOrchestrator.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }

    @Override
    public void showTrainingScreen(Category category) {
        TrainingFragment trainingFragment = TrainingFragment.newInstance(category);
        fragmentOrchestrator.showFragment(trainingFragment);
    }

    @Override
    public void showExamScreen(Category category) {
        ExamFragment examFragment = ExamFragment.newInstance(category);
        fragmentOrchestrator.showFragment(examFragment);
    }
}
