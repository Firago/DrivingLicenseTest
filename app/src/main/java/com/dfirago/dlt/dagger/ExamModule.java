package com.dfirago.dlt.dagger;

import com.dfirago.dlt.screen.exam.ExamPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by firag on 10/7/2017.
 */
@Module
public class ExamModule {

    @Provides
    @Singleton
    ExamPresenter provideExamPresenter() {
        return new ExamPresenter();
    }
}