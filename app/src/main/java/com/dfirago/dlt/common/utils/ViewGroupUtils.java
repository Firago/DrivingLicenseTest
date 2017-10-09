package com.dfirago.dlt.common.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class ViewGroupUtils {

    public static ViewGroup getParent(View view) {
        return (ViewGroup) view.getParent();
    }

    public static void removeView(View view) {
        ViewGroup parent = getParent(view);
        if (parent != null) {
            parent.removeView(view);
        }
    }

    public static void replaceView(View currentView, View newView) {
        ViewGroup parent = getParent(currentView);
        if (parent != null) {
            final int index = parent.indexOfChild(currentView);
            removeView(currentView);
            removeView(newView);
            parent.addView(newView, index);
        }
    }
}