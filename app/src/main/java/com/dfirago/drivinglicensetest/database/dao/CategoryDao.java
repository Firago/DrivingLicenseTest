package com.dfirago.drivinglicensetest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
@Dao
public interface CategoryDao {

    @Query("select * from category where categoryType = :type limit 1")
    Category findCategoryByType(CategoryType type);

    @Query("delete from category")
    void deleteAll();

    @Insert
    long insert(Category category);
}
