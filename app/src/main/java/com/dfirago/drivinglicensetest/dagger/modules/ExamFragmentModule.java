package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.fragments.ExamFragment;
import com.dfirago.drivinglicensetest.views.ExamView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
@Module(includes = QuestionViewModule.class)
public interface ExamFragmentModule {

    @Binds
    ExamView examView(ExamFragment examFragment);
}
