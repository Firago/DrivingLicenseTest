package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.fragments.TrainingFragment;
import com.dfirago.drivinglicensetest.views.TrainingView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
@Module(includes = QuestionViewModule.class)
public interface TrainingFragmentModule {

    @Binds
    TrainingView trainingView(TrainingFragment trainingFragment);
}
