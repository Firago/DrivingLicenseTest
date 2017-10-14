package com.dfirago.drivinglicensetest.common.model.converters;


import com.dfirago.drivinglicensetest.common.model.QuestionType;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class QuestionTypeConverter implements PropertyConverter<QuestionType, String> {

    @Override
    public QuestionType convertToEntityProperty(String databaseValue) {
        return databaseValue == null ? null : QuestionType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(QuestionType entityProperty) {
        return entityProperty == null ? null : entityProperty.name();
    }
}
