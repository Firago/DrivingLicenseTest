package com.dfirago.drivinglicensetest.common.database.impl;

import com.dfirago.drivinglicensetest.common.database.ConfigurationDao;
import com.dfirago.drivinglicensetest.common.model.ConfigurationEntry;
import com.dfirago.drivinglicensetest.common.model.ConfigurationKey;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class ConfigurationDaoImpl implements ConfigurationDao {

    private Box<ConfigurationEntry> configurationBox;

    @Inject
    public ConfigurationDaoImpl(BoxStore boxStore) {
        this.configurationBox = boxStore.boxFor(ConfigurationEntry.class);
    }

    @Override
    public ConfigurationEntry findByKey(ConfigurationKey key, boolean createIfNotExists) {
        List<ConfigurationEntry> entryList = configurationBox.find("key", key.name());
        ListIterator<ConfigurationEntry> iterator = entryList.listIterator();
        ConfigurationEntry configurationEntry = iterator.hasNext() ? iterator.next() : null;
        if (configurationEntry == null) {
            configurationEntry = new ConfigurationEntry(key, key.getDefaultValue());
            configurationBox.put(configurationEntry);
        }
        return configurationEntry;
    }

    @Override
    public void put(ConfigurationEntry configurationEntry) {
        configurationBox.put(configurationEntry);
    }

    @Override
    public List<ConfigurationEntry> getByKeys(ConfigurationKey... keys) {
        return getByKeys(Arrays.asList(keys));
    }

    @Override
    public List<ConfigurationEntry> getByKeys(List<ConfigurationKey> keys) {
        return configurationBox.query()
                .filter(entity -> keys.contains(entity.getKey()))
                .build().find();
    }

    @Override
    public void removeAll() {
        configurationBox.removeAll();
    }
}
