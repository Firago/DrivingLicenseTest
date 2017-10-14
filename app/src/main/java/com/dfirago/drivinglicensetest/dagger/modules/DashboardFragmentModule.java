package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.fragments.DashboardFragment;
import com.dfirago.drivinglicensetest.views.DashboardView;

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
