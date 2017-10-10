package com.dfirago.dlt.common.utils;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/10/2017.
 */
public class ColorProvider {

    private Context context;

    @Inject
    public ColorProvider(Context context) {
        this.context = context;
    }

    @ColorInt
    public int getColor(@ColorRes int colorResId) {
        return ContextCompat.getColor(context, colorResId);
    }
}
