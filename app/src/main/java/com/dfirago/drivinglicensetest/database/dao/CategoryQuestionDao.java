package com.dfirago.drivinglicensetest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.dfirago.drivinglicensetest.database.model.relationships.CategoryQuestion;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
@Dao
public interface CategoryQuestionDao {

    @Insert
    void insert(CategoryQuestion categoryQuestion);
}
