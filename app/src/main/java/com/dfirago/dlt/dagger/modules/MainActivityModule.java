package com.dfirago.dlt.dagger.modules;

import com.dfirago.dlt.MainActivity;
import com.dfirago.dlt.dagger.scopes.ActivityScope;
import com.dfirago.dlt.dagger.scopes.FragmentScope;
import com.dfirago.dlt.fragments.CategoryFragment;
import com.dfirago.dlt.fragments.DashboardFragment;
import com.dfirago.dlt.fragments.ExamFragment;
import com.dfirago.dlt.fragments.TrainingFragment;
import com.dfirago.dlt.fragments.questions.ImageQuestionFragment;
import com.dfirago.dlt.fragments.questions.SimpleQuestionFragment;
import com.dfirago.dlt.fragments.questions.VideoQuestionFragment;
import com.dfirago.dlt.navigation.FragmentOrchestrator;
import com.dfirago.dlt.navigation.NavigationManager;
import com.dfirago.dlt.navigation.impl.NavigationManagerImpl;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by firag on 10/7/2017.
 */
@Module
public interface MainActivityModule {

    @ActivityScope
    @Binds
    NavigationManager navigationManager(NavigationManagerImpl navigationManager);

    @ActivityScope
    @Binds
    FragmentOrchestrator fragmentOrchestrator(MainActivity mainActivity);

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

    @FragmentScope
    @ContributesAndroidInjector
    SimpleQuestionFragment simpleQuestionFragment();

    @FragmentScope
    @ContributesAndroidInjector
    ImageQuestionFragment imageQuestionFragment();

    @FragmentScope
    @ContributesAndroidInjector
    VideoQuestionFragment videoQuestionFragment();
}