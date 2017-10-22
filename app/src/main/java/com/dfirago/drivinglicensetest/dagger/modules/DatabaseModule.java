package com.dfirago.drivinglicensetest.dagger.modules;

import android.content.Context;

import com.dfirago.drivinglicensetest.common.database.CategoryService;
import com.dfirago.drivinglicensetest.common.database.ConfigurationService;
import com.dfirago.drivinglicensetest.common.database.QuestionService;
import com.dfirago.drivinglicensetest.common.database.impl.CategoryServiceImpl;
import com.dfirago.drivinglicensetest.common.database.impl.ConfigurationServiceImpl;
import com.dfirago.drivinglicensetest.common.database.impl.QuestionServiceImpl;
import com.dfirago.drivinglicensetest.common.model.MyObjectBox;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
@Module
public abstract class DatabaseModule {

    @Singleton
    @Provides
    static BoxStore boxStore(Context context) {
        return MyObjectBox.builder().androidContext(context).build();
    }

    @Singleton
    @Binds
    abstract ConfigurationService configurationService(ConfigurationServiceImpl configurationService);

    @Singleton
    @Binds
    abstract QuestionService questionService(QuestionServiceImpl questionService);

    @Singleton
    @Binds
    abstract CategoryService categoryService(CategoryServiceImpl categoryService);
}
