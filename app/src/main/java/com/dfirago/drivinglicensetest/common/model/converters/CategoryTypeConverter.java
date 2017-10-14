package com.dfirago.drivinglicensetest.common.model.converters;

import com.dfirago.drivinglicensetest.common.model.CategoryType;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class CategoryTypeConverter implements PropertyConverter<CategoryType, String> {

    @Override
    public CategoryType convertToEntityProperty(String databaseValue) {
        return databaseValue == null ? null : CategoryType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(CategoryType entityProperty) {
        return entityProperty == null ? null : entityProperty.name();
    }
}
