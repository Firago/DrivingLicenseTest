package com.dfirago.drivinglicensetest.presenters;

import android.util.Log;

import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.common.setup.SetupExecutionHelper;
import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.views.DashboardView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dmytro Firago on 14/07/2017.
 */
@FragmentScope
public class DashboardPresenter {

    private static final String TAG = "DashboardPresenter";

    private DashboardView view;
    private SetupExecutionHelper setupExecutionHelper;

    @Inject
    public DashboardPresenter(DashboardView view, SetupExecutionHelper setupExecutionHelper) {
        this.view = view;
        this.setupExecutionHelper = setupExecutionHelper;
    }

    public void onCategorySelected(CategoryType categoryType) {
        view.showCategoryScreen(categoryType);
    }

    public void onRateApplicationSelected() {
        view.showRateApplicationScreen();
    }

    public void performSetupIfNeeded() {
        Log.d(TAG, "Verifying if setup is needed");
        boolean setupNeeded = setupExecutionHelper.isSetupNeeded();
        Log.d(TAG, "Setup needed flag: " + setupNeeded);
        if (setupNeeded) {
            setupExecutionHelper.executeSetup()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> view.onSetupStarted())
                    .doOnComplete(() -> {
                        view.onSetupFinished();
                        view.onSetupSuccess();
                    })
                    .doOnError(throwable -> {
                        view.onSetupFinished();
                        view.onSetupError(throwable);
                    })
                    .subscribe();
        }
    }
}
