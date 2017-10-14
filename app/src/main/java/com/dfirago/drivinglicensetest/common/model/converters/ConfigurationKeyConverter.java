package com.dfirago.drivinglicensetest.common.model.converters;

import com.dfirago.drivinglicensetest.common.model.ConfigurationKey;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class ConfigurationKeyConverter implements PropertyConverter<ConfigurationKey, String> {

    @Override
    public ConfigurationKey convertToEntityProperty(String databaseValue) {
        return databaseValue == null ? null : ConfigurationKey.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(ConfigurationKey entityProperty) {
        return entityProperty == null ? null : entityProperty.name();
    }
}
