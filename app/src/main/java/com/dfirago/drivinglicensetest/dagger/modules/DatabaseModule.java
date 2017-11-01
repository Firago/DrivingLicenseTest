package com.dfirago.drivinglicensetest.dagger.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dfirago.drivinglicensetest.database.AppDatabase;
import com.dfirago.drivinglicensetest.database.dao.CategoryDao;
import com.dfirago.drivinglicensetest.database.dao.CategoryQuestionDao;
import com.dfirago.drivinglicensetest.database.dao.ConfigurationDao;
import com.dfirago.drivinglicensetest.database.dao.QuestionDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
@Module
public abstract class DatabaseModule {

    @Singleton
    @Provides
    static AppDatabase appDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "driving-license-test-db")
                .allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    static QuestionDao questionDao(AppDatabase appDatabase) {
        return appDatabase.questionDao();
    }

    @Singleton
    @Provides
    static CategoryDao categoryDao(AppDatabase appDatabase) {
        return appDatabase.categoryDao();
    }

    @Singleton
    @Provides
    static ConfigurationDao configurationDao(AppDatabase appDatabase) {
        return appDatabase.configurationDao();
    }

    @Singleton
    @Provides
    static CategoryQuestionDao categoryQuestionDao(AppDatabase appDatabase) {
        return appDatabase.categoryQuestionDao();
    }
}
