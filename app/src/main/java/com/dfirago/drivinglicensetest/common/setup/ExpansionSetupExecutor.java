package com.dfirago.drivinglicensetest.common.setup;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class ExpansionSetupExecutor implements SetupExecutor {

    private final static String TAG = "ExpansionSetupExecutor";

    @Inject
    public ExpansionSetupExecutor() {

    }

    @Override
    public Object execute() throws Exception {

        Log.d(TAG, "Downloading expansion file - START");

        // TODO download .obb if needed
        Thread.sleep(2000);

        Log.d(TAG, "Downloading expansion file - FINISH");

        return new Object();
    }
}
