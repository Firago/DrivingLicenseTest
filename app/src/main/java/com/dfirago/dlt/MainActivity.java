package com.dfirago.dlt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.dfirago.dlt.navigation.FragmentOrchestrator;
import com.dfirago.dlt.navigation.impl.NavigationManagerImpl;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends FragmentActivity implements HasSupportFragmentInjector, FragmentOrchestrator {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject
    NavigationManagerImpl navigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationManager.showDashboardScreen();
    }

    @Override
    public void showFragment(int containerViewId, Fragment fragment) {
        if (getSupportFragmentManager().findFragmentById(containerViewId) != null) {
            replace(containerViewId, fragment);
        } else {
            showFragment(fragment);
        }
    }

    @Override
    public void showFragment(Fragment fragment) {
        replace(R.id.content_container, fragment);
    }

    private void replace(int containerViewId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in_right, R.anim.fade_out,
                        R.anim.slide_in_left, R.anim.fade_out)
                .replace(containerViewId, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
