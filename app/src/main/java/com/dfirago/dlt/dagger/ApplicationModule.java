package com.dfirago.dlt.dagger;

import android.app.Application;
import android.content.res.AssetManager;

import com.dfirago.dlt.MainActivity;
import com.dfirago.dlt.screen.category.CategoryFragment;
import com.dfirago.dlt.screen.dashboard.DashboardFragment;
import com.dfirago.dlt.screen.exam.ExamFragment;
import com.dfirago.dlt.screen.training.TrainingFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module
public abstract class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    AssetManager provideAssetsManager(Application application) {
        return application.getAssets();
    }

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract DashboardFragment contributeDashboardFragment();

    @ContributesAndroidInjector
    abstract CategoryFragment contributeCategoryFragment();

    @ContributesAndroidInjector
    abstract TrainingFragment contributeTrainingFragment();

    @ContributesAndroidInjector
    abstract ExamFragment contributeExamFragment();
}
