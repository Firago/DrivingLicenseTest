package com.dfirago.dlt.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import com.dfirago.dlt.MainActivity;
import com.dfirago.dlt.common.database.QuestionRepository;
import com.dfirago.dlt.common.database.impl.QuestionRepositoryImpl;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.ImageQuestion;
import com.dfirago.dlt.common.model.SimpleQuestion;
import com.dfirago.dlt.common.model.VideoQuestion;
import com.dfirago.dlt.common.utils.AssetReader;
import com.dfirago.dlt.common.utils.ColorProvider;
import com.dfirago.dlt.dagger.scopes.ActivityScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module(includes = {AndroidSupportInjectionModule.class})
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
        return new GsonBuilder()
                .registerTypeAdapterFactory(
                        RuntimeTypeAdapterFactory
                                .of(AbstractQuestion.class)
                                .registerSubtype(SimpleQuestion.class)
                                .registerSubtype(ImageQuestion.class)
                                .registerSubtype(VideoQuestion.class))
                .create();
    }

    @Singleton
    @Binds
    abstract QuestionRepository questionRepository(QuestionRepositoryImpl questionRepository);

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivityInjector();
}