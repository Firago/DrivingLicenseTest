package com.dfirago.drivinglicensetest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.dfirago.drivinglicensetest.database.dao.CategoryDao;
import com.dfirago.drivinglicensetest.database.dao.CategoryQuestionDao;
import com.dfirago.drivinglicensetest.database.dao.ConfigurationDao;
import com.dfirago.drivinglicensetest.database.dao.QuestionDao;
import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.entities.ConfigurationEntry;
import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.relationships.CategoryQuestion;
import com.dfirago.drivinglicensetest.database.utils.Converters;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
@Database(version = 1, entities = {
        Question.class,
        Category.class,
        CategoryQuestion.class,
        ConfigurationEntry.class
})
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract QuestionDao questionDao();

    public abstract CategoryDao categoryDao();

    public abstract ConfigurationDao configurationDao();

    public abstract CategoryQuestionDao categoryQuestionDao();
}
