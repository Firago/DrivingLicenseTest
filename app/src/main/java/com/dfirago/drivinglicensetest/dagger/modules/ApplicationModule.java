package com.dfirago.drivinglicensetest.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import com.dfirago.drivinglicensetest.MainActivity;
import com.dfirago.drivinglicensetest.common.utils.AssetReader;
import com.dfirago.drivinglicensetest.common.utils.ColorProvider;
import com.dfirago.drivinglicensetest.dagger.scopes.ActivityScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module(includes = {
        AndroidSupportInjectionModule.class,
        DatabaseModule.class,
        SetupModule.class
})
public abstract class ApplicationModule {

    @Singleton
    @Provides
    static Context context(Application application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    static AssetManager assetManager(Application application) {
        return application.getAssets();
    }

    @Singleton
    @Provides
    static AssetReader assetReader(AssetManager assetManager) {
        return new AssetReader(assetManager);
    }

    @Singleton
    @Provides
    static ColorProvider colorProvider(Application application) {
        return new ColorProvider(application);
    }

    @Singleton
    @Provides
    static Gson provideGson() {
        return new GsonBuilder().create();
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivityInjector();
}