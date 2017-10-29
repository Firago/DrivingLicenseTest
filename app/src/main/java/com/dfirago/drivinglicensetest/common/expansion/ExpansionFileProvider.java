package com.dfirago.drivinglicensetest.common.expansion;

import android.net.Uri;

import com.google.android.vending.expansion.zipfile.APEZProvider;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/29/2017.
 */
public class ExpansionFileProvider extends APEZProvider {

    private static final String CONTENT_PREFIX = "content://";

    private static final String AUTHORITY = "com.dfirago.drivinglicensetest.provider.ExpansionFileProvider";

    public static final Uri EXPANSION_URI = Uri.parse(CONTENT_PREFIX + AUTHORITY);

    public String getAuthority() {
        return AUTHORITY;
    }

    public static Uri getUri(String fileName) {
        return Uri.withAppendedPath(ExpansionFileProvider.EXPANSION_URI, fileName);
    }
}
