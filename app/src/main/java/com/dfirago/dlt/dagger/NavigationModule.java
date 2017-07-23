package com.dfirago.dlt.dagger;

import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module
public class NavigationModule {

    @Provides
    @Singleton
    NavigationManager provideNavigationManager() {
        return new NavigationManager();
    }
}
