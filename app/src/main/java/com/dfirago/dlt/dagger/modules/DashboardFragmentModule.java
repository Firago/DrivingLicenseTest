package com.dfirago.dlt.dagger.modules;

import com.dfirago.dlt.fragments.DashboardFragment;
import com.dfirago.dlt.views.DashboardView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
@Module
public interface DashboardFragmentModule {

    @Binds
    DashboardView dashboardView(DashboardFragment dashboardFragment);
}
