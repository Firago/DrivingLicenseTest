package com.dfirago.drivinglicensetest.common.model;

import com.dfirago.drivinglicensetest.common.model.converters.QuestionGroupConverter;
import com.dfirago.drivinglicensetest.common.model.converters.QuestionTypeConverter;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/12/2017.
 */
@Entity
public class Question {

    @Id
    private long id;
    @Convert(converter = QuestionTypeConverter.class, dbType = String.class)
    private QuestionType type;
    private String value;
    @Backlink
    private ToMany<ResponseOption> options;
    @Convert(converter = QuestionGroupConverter.class, dbType = String.class)
    private QuestionGroup group;
    private ToMany<Category> categories;
    private String comment;
    private int points;
    private String media;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public ToMany<ResponseOption> getOptions() {
        return options;
    }

    public void setOptions(ToMany<ResponseOption> options) {
        this.options = options;
    }

    public QuestionGroup getGroup() {
        return group;
    }

    public void setGroup(QuestionGroup group) {
        this.group = group;
    }

    public ToMany<Category> getCategories() {
        return categories;
    }

    public void setCategories(ToMany<Category> categories) {
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
