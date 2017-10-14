package com.dfirago.drivinglicensetest.presenters;

import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.setup.SetupExecutor;
import com.dfirago.drivinglicensetest.views.DashboardView;

import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dmytro Firago on 14/07/2017.
 */
public class DashboardPresenter {

    private DashboardView view;
    private Set<SetupExecutor> setupExecutors;

    @Inject
    public DashboardPresenter(DashboardView view, Set<SetupExecutor> setupExecutors) {
        this.view = view;
        this.setupExecutors = setupExecutors;
    }

    public void onCategorySelected(CategoryType categoryType) {
        view.showCategoryScreen(categoryType);
    }

    public void onRateApplicationSelected() {
        view.showRateApplicationScreen();
    }

    public void startSetup() {
        Observable.fromIterable(setupExecutors)
                .map(SetupExecutor::execute)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.onSetupStarted())
                .subscribe(
                        success -> {
                            view.onSetupFinished();
                            view.onSetupSuccess();
                        },
                        error -> {
                            view.onSetupFinished();
                            view.onSetupError();
                        }
                );
    }
}
