package com.dfirago.drivinglicensetest.dagger.mappings;

import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/11/2017.
 */
@MapKey
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QuestionViewBuilderKey {
    QuestionType value();
}
