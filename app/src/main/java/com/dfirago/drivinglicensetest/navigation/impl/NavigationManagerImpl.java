package com.dfirago.drivinglicensetest.navigation.impl;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.fragments.CategoryFragment;
import com.dfirago.drivinglicensetest.fragments.DashboardFragment;
import com.dfirago.drivinglicensetest.fragments.ExamFragment;
import com.dfirago.drivinglicensetest.fragments.TrainingFragment;
import com.dfirago.drivinglicensetest.navigation.FragmentOrchestrator;
import com.dfirago.drivinglicensetest.navigation.NavigationManager;

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
    public void showCategoryScreen(CategoryType categoryType) {
        CategoryFragment categoryFragment = CategoryFragment.newInstance(categoryType);
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
    public void showTrainingScreen(CategoryType categoryType) {
        TrainingFragment trainingFragment = TrainingFragment.newInstance(categoryType);
        fragmentOrchestrator.showFragment(trainingFragment);
    }

    @Override
    public void showExamScreen(CategoryType categoryType) {
        ExamFragment examFragment = ExamFragment.newInstance(categoryType);
        fragmentOrchestrator.showFragment(examFragment);
    }
}
