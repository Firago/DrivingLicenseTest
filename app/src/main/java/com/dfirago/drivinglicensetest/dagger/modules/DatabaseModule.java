package com.dfirago.drivinglicensetest.dagger.modules;

import android.content.Context;

import com.dfirago.drivinglicensetest.common.database.QuestionRepository;
import com.dfirago.drivinglicensetest.common.database.impl.QuestionRepositoryImpl;
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
    abstract QuestionRepository questionRepository(QuestionRepositoryImpl questionRepository);
}
