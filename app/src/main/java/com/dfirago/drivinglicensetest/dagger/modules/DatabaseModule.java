package com.dfirago.drivinglicensetest.dagger.modules;

import android.content.Context;

import com.dfirago.drivinglicensetest.common.database.CategoryDao;
import com.dfirago.drivinglicensetest.common.database.ConfigurationDao;
import com.dfirago.drivinglicensetest.common.database.QuestionDao;
import com.dfirago.drivinglicensetest.common.database.impl.CategoryDaoImpl;
import com.dfirago.drivinglicensetest.common.database.impl.ConfigurationDaoImpl;
import com.dfirago.drivinglicensetest.common.database.impl.QuestionDaoImpl;
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
    abstract ConfigurationDao configurationDao(ConfigurationDaoImpl configurationDao);

    @Singleton
    @Binds
    abstract QuestionDao questionDao(QuestionDaoImpl questionDao);

    @Singleton
    @Binds
    abstract CategoryDao categoryDao(CategoryDaoImpl categoryDao);
}
