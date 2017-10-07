package com.dfirago.dlt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.dfirago.dlt.navigation.FragmentOrchestrator;
import com.dfirago.dlt.navigation.NavigationManager;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends FragmentActivity implements FragmentOrchestrator {

    @Inject
    NavigationManager navigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationManager.attach(this);
        navigationManager.showDashboardScreen();
    }

    @Override
    protected void onDestroy() {
        navigationManager.detach();
        super.onDestroy();
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
}
