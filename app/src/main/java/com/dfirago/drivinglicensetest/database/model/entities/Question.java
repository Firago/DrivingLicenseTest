package com.dfirago.drivinglicensetest.database.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.dfirago.drivinglicensetest.database.model.types.ResponseOption;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionGroup;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/12/2017.
 */
@Entity
public class Question {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private QuestionType type;
    private String value;
    private List<ResponseOption> options = new ArrayList<>();
    private QuestionGroup group;
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

    public List<ResponseOption> getOptions() {
        return options;
    }

    public void setOptions(List<ResponseOption> options) {
        this.options = options;
    }

    public QuestionGroup getGroup() {
        return group;
    }

    public void setGroup(QuestionGroup group) {
        this.group = group;
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

    public ResponseOption getCorrectOption() {
        for (ResponseOption option : options) {
            if (option.isCorrect()) {
                return option;
            }
        }
        throw new IllegalStateException("Question should contain at least one correct response option");
    }
}
