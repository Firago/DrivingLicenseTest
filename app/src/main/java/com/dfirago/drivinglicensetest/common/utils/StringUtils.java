package com.dfirago.drivinglicensetest.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/27/2017.
 */
public final class StringUtils {

    private static final DateFormat DEFAULT_FORMATTER = new SimpleDateFormat("mm:ss", Locale.getDefault());

    public static String millisToTimeString(long millis) {
        return DEFAULT_FORMATTER.format(new Date(millis));
    }
}
