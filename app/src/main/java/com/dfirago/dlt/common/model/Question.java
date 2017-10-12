package com.dfirago.dlt.common.model;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/12/2017.
 */
public class Question {

    private QuestionType type;
    private String value;
    private List<ResponseOption> options;
    private QuestionComplexity complexity;
    private List<Category> categories;
    private String comment;
    private int points;
    private String media;

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

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

    public QuestionComplexity getComplexity() {
        return complexity;
    }

    public void setComplexity(QuestionComplexity complexity) {
        this.complexity = complexity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
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

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}
