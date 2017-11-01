package com.dfirago.drivinglicensetest.common.setup;

import android.util.Log;

import com.dfirago.drivinglicensetest.database.dao.ConfigurationDao;
import com.dfirago.drivinglicensetest.database.model.entities.ConfigurationEntry;
import com.dfirago.drivinglicensetest.database.model.enums.ConfigurationKey;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class ExpansionSetupExecutor implements SetupExecutor {

    private final static String TAG = "ExpansionSetupExecutor";

    private ConfigurationDao configurationDao;

    @Inject
    public ExpansionSetupExecutor(ConfigurationDao configurationDao) {
        this.configurationDao = configurationDao;
    }

    @Override
    public boolean execute() throws Exception {
        Log.d(TAG, "Checking if expansion needs to be downloaded based on EXPANSION_READY flag");
        Boolean expansionReady = isExpansionReady();
        Log.d(TAG, "EXPANSION_READY entry value: " + expansionReady);
        if (!Boolean.TRUE.equals(expansionReady)) {
            downloadExpansion();
            configurationDao.update(ConfigurationKey.EXPANSION_READY, String.valueOf(true));
            return true;
        }
        return false;
    }

    private Boolean isExpansionReady() {
        String expansionReadyValue = configurationDao.findByKey(ConfigurationKey.EXPANSION_READY);
        if (expansionReadyValue == null) {
            expansionReadyValue = String.valueOf(false);
            ConfigurationEntry entry = new ConfigurationEntry();
            entry.setKey(ConfigurationKey.EXPANSION_READY);
            entry.setValue(String.valueOf(false));
            configurationDao.insert(entry);
        }
        return Boolean.valueOf(expansionReadyValue);
    }

    private void downloadExpansion() throws InterruptedException {
        Log.d(TAG, "Downloading expansion file - START");
        // TODO download .obb if needed
        Thread.sleep(2000);
        Log.d(TAG, "Downloading expansion file - FINISH");
    }
}
