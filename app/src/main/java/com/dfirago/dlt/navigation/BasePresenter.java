package com.dfirago.dlt.navigation;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.reflect.Proxy;

/**
 * Created by Dmytro Firago on 14/07/2017.
 */
public abstract class BasePresenter<View> {

    @Nullable
    private View view;

    protected abstract Class viewClass();

    @CallSuper
    public void attachView(@NonNull View view) {
        this.view = view;
    }

    @NonNull
    protected View view() {
        return view;
    }

    @SuppressWarnings("unchecked")
    private View emptyView() {
        final Class viewClass = viewClass();
        return (View) Proxy.newProxyInstance(viewClass.getClassLoader(),
                new Class[]{viewClass}, (proxy, method, args) -> {
                    Log.d(getClass().getSimpleName(), "Empty view instance.");
                    return null;
                });
    }

    @CallSuper
    public void detachView() {
        view = emptyView();
    }
}
