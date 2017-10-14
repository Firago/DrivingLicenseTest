package com.dfirago.drivinglicensetest.common.model.converters;

import com.dfirago.drivinglicensetest.common.model.QuestionGroup;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class QuestionGroupConverter implements PropertyConverter<QuestionGroup, String> {

    @Override
    public QuestionGroup convertToEntityProperty(String databaseValue) {
        return databaseValue == null ? null : QuestionGroup.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(QuestionGroup entityProperty) {
        return entityProperty == null ? null : entityProperty.name();
    }
}
