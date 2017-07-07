package com.dfirago.dlt.question.common.model;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class ResponseOption {

    private String value;
    private boolean correct;

    public ResponseOption(String value, boolean correct) {
        this.value = value;
        this.correct = correct;
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
}
