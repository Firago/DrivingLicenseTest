package com.dfirago.drivinglicensetest.common.setup;

import com.dfirago.drivinglicensetest.common.database.ConfigurationService;
import com.dfirago.drivinglicensetest.common.model.ConfigurationEntry;
import com.dfirago.drivinglicensetest.common.model.ConfigurationKey;

import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class SetupExecutionHelper {

    private final ConfigurationKey[] setupReadyFlags = new ConfigurationKey[]{
            ConfigurationKey.DATABASE_READY,
            ConfigurationKey.EXPANSION_READY
    };

    private ConfigurationService configurationService;
    private Set<SetupExecutor> setupExecutors;

    @Inject
    public SetupExecutionHelper(ConfigurationService configurationService, Set<SetupExecutor> setupExecutors) {
        this.configurationService = configurationService;
        this.setupExecutors = setupExecutors;
    }

    /**
     * Checks if any setup steps need to be executed based on flags stored in the database
     *
     * @return true if at least one setup flag does not exist or at least one flag is set to false
     */
    public boolean isSetupNeeded() {
        List<ConfigurationEntry> configurationEntries = configurationService.getByKeys(setupReadyFlags);
        if (setupReadyFlags.length != configurationEntries.size()) {
            return true;
        }
        for (ConfigurationEntry entry : configurationEntries) {
            if (StringUtils.isEmpty(entry.getValue())
                    || Boolean.valueOf(entry.getValue()).equals(Boolean.FALSE)) {
                return true;
            }
        }
        return false;
    }

    public Observable<Boolean> executeSetup() {
        return Observable.fromIterable(setupExecutors).map(SetupExecutor::execute);
    }
}
