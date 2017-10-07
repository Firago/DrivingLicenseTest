package com.dfirago.dlt.dagger.components;

import android.app.Application;

import com.dfirago.dlt.DaggerApplication;
import com.dfirago.dlt.dagger.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(DaggerApplication application);
}
