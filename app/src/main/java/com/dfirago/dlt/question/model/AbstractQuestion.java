package com.dfirago.dlt.question.model;

import java.util.List;

/**
 * Created by Dmytro Firago on 13/06/2017.
 */
public abstract class AbstractQuestion {

    private String value;
    private List<ResponseOption> options;

    public AbstractQuestion(String value, List<ResponseOption> options) {
        this.value = value;
        this.options = options;
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
}
