package com.dfirago.drivinglicensetest.common.model;

import com.dfirago.drivinglicensetest.common.model.converters.CategoryTypeConverter;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
@Entity
public class Category {

    @Id
    private long id;
    @Convert(converter = CategoryTypeConverter.class, dbType = String.class)
    private CategoryType categoryType;
    private ToMany<Question> questions;

    public Category() {

    }

    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public ToMany<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ToMany<Question> questions) {
        this.questions = questions;
    }
}
