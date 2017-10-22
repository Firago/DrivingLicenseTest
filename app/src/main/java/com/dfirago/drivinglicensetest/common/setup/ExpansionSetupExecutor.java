package com.dfirago.drivinglicensetest.common.setup;

import android.util.Log;

import com.dfirago.drivinglicensetest.common.database.ConfigurationService;
import com.dfirago.drivinglicensetest.common.model.ConfigurationEntry;
import com.dfirago.drivinglicensetest.common.model.ConfigurationKey;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class ExpansionSetupExecutor implements SetupExecutor {

    private final static String TAG = "ExpansionSetupExecutor";

    private ConfigurationService configurationService;

    @Inject
    public ExpansionSetupExecutor(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @Override
    public boolean execute() throws Exception {
        Log.d(TAG, "Checking if expansion needs to be downloaded based on EXPANSION_READY flag");
        ConfigurationEntry expansionReadyEntry = configurationService
                .findByKey(ConfigurationKey.EXPANSION_READY, true);
        Log.d(TAG, "EXPANSION_READY flag is set to " + expansionReadyEntry.getValue());
        if (Boolean.valueOf(expansionReadyEntry.getValue()).equals(Boolean.FALSE)) {
            downloadExpansion();
            expansionReadyEntry.setValue(String.valueOf(true));
            configurationService.put(expansionReadyEntry);
            return true;
        }
        return false;
    }

    private void downloadExpansion() throws InterruptedException {
        Log.d(TAG, "Downloading expansion file - START");
        // TODO download .obb if needed
        Thread.sleep(2000);
        Log.d(TAG, "Downloading expansion file - FINISH");
    }
}
