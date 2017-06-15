package com.dfirago.dlt.training.model;

import java.util.List;

/**
 * Created by Dmytro Firago on 13/06/2017.
 */
public abstract class AbstractQuestion {

    private String value;
    private List<Option> options;

    public AbstractQuestion(String value, List<Option> options) {
        this.value = value;
        this.options = options;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
