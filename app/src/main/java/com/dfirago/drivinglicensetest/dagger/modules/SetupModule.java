package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.common.setup.DatabaseSetupExecutor;
import com.dfirago.drivinglicensetest.common.setup.ExpansionSetupExecutor;
import com.dfirago.drivinglicensetest.common.setup.SetupExecutor;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
@Module
public abstract class SetupModule {

    @Binds
    @IntoSet
    @Singleton
    abstract SetupExecutor databaseSetupExecutor(DatabaseSetupExecutor setupExecutor);

    @Binds
    @IntoSet
    @Singleton
    abstract SetupExecutor expansionSetupExecutor(ExpansionSetupExecutor setupExecutor);
}
