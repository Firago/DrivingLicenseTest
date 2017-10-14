package com.dfirago.drivinglicensetest.common.database;

import com.dfirago.drivinglicensetest.common.model.ConfigurationEntry;
import com.dfirago.drivinglicensetest.common.model.ConfigurationKey;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public interface ConfigurationDao {

    ConfigurationEntry findByKey(ConfigurationKey key, boolean createIfNotExists);

    void put(ConfigurationEntry configurationEntry);

    List<ConfigurationEntry> getByKeys(ConfigurationKey... keys);

    List<ConfigurationEntry> getByKeys(List<ConfigurationKey> keys);

    void removeAll();
}
