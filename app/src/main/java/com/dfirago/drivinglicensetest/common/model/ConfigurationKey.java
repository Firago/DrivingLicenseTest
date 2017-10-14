package com.dfirago.drivinglicensetest.common.model;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public enum ConfigurationKey {

    DATABASE_READY("false"),
    EXPANSION_READY("false");

    private String defaultValue;

    ConfigurationKey(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
