package com.dfirago.dlt.dagger.modules;

import com.dfirago.dlt.fragments.TrainingFragment;
import com.dfirago.dlt.views.TrainingView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
@Module
public interface TrainingFragmentModule {

    @Binds
    TrainingView trainingView(TrainingFragment trainingFragment);
}
