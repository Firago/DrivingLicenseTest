package com.dfirago.drivinglicensetest.database.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.dfirago.drivinglicensetest.database.model.enums.ConfigurationKey;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
@Entity(tableName = "Configuration")
public class ConfigurationEntry {

    @PrimaryKey(autoGenerate = true)
    private long id;
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
