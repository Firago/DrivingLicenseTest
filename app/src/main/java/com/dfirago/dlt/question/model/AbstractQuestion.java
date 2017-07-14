package com.dfirago.dlt.question.model;

import com.dfirago.dlt.common.CategoryType;

import java.util.List;

/**
 * Created by Dmytro Firago on 13/06/2017.
 */
public abstract class AbstractQuestion {

    private String value;
    private List<ResponseOption> options;
    private QuestionType questionType;
    private List<CategoryType> categories;
    private String comment;
    private int points;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ResponseOption> getOptions() {
        return options;
    }

    public void setOptions(List<ResponseOption> options) {
        this.options = options;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<CategoryType> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryType> categories) {
        this.categories = categories;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
