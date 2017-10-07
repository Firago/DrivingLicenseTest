package com.dfirago.dlt;

import com.dfirago.dlt.dagger.ApplicationModule;
import com.dfirago.dlt.dagger.AssetModule;
import com.dfirago.dlt.dagger.CategoryModule;
import com.dfirago.dlt.dagger.DashboardModule;
import com.dfirago.dlt.dagger.ExamModule;
import com.dfirago.dlt.dagger.NavigationModule;
import com.dfirago.dlt.dagger.QuestionModule;
import com.dfirago.dlt.dagger.TrainingModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        NavigationModule.class,
        AssetModule.class,
        QuestionModule.class,
        DashboardModule.class,
        CategoryModule.class,
        TrainingModule.class,
        ExamModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

}
