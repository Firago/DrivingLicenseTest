package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.MainActivity;
import com.dfirago.drivinglicensetest.dagger.scopes.ActivityScope;
import com.dfirago.drivinglicensetest.navigation.FragmentOrchestrator;
import com.dfirago.drivinglicensetest.navigation.NavigationManager;
import com.dfirago.drivinglicensetest.navigation.impl.NavigationManagerImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by firag on 10/7/2017.
 */
@Module(includes = {
        FragmentProviderModule.class,
})
public interface MainActivityModule {

    @ActivityScope
    @Binds
    NavigationManager navigationManager(NavigationManagerImpl navigationManager);

    @ActivityScope
    @Binds
    FragmentOrchestrator fragmentOrchestrator(MainActivity mainActivity);
}