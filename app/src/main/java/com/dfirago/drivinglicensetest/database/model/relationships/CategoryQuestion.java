package com.dfirago.drivinglicensetest.database.model.relationships;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
@Entity
public class CategoryQuestion {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long categoryId;
    private long questionId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
