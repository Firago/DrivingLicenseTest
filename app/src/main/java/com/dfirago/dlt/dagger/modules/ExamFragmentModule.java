package com.dfirago.dlt.dagger.modules;

import com.dfirago.dlt.fragments.ExamFragment;
import com.dfirago.dlt.views.ExamView;

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
