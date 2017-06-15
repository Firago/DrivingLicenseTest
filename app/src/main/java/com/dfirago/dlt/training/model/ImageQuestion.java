package com.dfirago.dlt.training.model;

import java.util.List;

/**
 * Created by Dmytro Firago on 13/06/2017.
 */
public class ImageQuestion extends AbstractQuestion {

    private int imageResId;

    public ImageQuestion(String question, List<Option> options, int imageResId) {
        super(question, options);
        this.imageResId = imageResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
