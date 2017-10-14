package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.fragments.CategoryFragment;
import com.dfirago.drivinglicensetest.fragments.DashboardFragment;
import com.dfirago.drivinglicensetest.fragments.ExamFragment;
import com.dfirago.drivinglicensetest.fragments.TrainingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
@Module
public interface FragmentProviderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {DashboardFragmentModule.class})
    DashboardFragment dashboardFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {CategoryFragmentModule.class})
    CategoryFragment categoryFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {TrainingFragmentModule.class})
    TrainingFragment trainingFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {ExamFragmentModule.class})
    ExamFragment examFragment();
}
