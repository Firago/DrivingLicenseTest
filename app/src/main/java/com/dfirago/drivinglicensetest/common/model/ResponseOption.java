package com.dfirago.drivinglicensetest.common.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
@Entity
public class ResponseOption {

    @Id
    private long id;
    private String value;
    private boolean correct;
    private ToOne<Question> question;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public ToOne<Question> getQuestion() {
        return question;
    }

    public void setQuestion(ToOne<Question> question) {
        this.question = question;
    }
}
