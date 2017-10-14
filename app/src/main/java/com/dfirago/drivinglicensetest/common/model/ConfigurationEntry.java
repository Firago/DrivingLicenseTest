package com.dfirago.drivinglicensetest.common.model;

import com.dfirago.drivinglicensetest.common.model.converters.ConfigurationKeyConverter;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
@Entity
public class ConfigurationEntry {

    @Id
    private long id;
    @Convert(converter = ConfigurationKeyConverter.class, dbType = String.class)
    private ConfigurationKey key;
    private String value;

    public ConfigurationEntry() {

    }

    public ConfigurationEntry(ConfigurationKey key, String value) {
        this.key = key;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ConfigurationKey getKey() {
        return key;
    }

    public void setKey(ConfigurationKey key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
