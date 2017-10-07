package com.dfirago.dlt.dagger;

import com.dfirago.dlt.screen.training.TrainingPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by firag on 10/7/2017.
 */
@Module
public class TrainingModule {

    @Provides
    @Singleton
    TrainingPresenter provideTrainingPresenter() {
        return new TrainingPresenter();
    }
}