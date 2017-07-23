package com.dfirago.dlt.dagger;

import com.dfirago.dlt.screen.dashboard.DashboardPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module
public class DashboardModule {

    @Provides
    @Singleton
    DashboardPresenter provideDashboardPresenter() {
        return new DashboardPresenter();
    }
}
