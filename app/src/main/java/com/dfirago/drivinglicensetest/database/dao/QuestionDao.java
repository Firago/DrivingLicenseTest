package com.dfirago.drivinglicensetest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dfirago.drivinglicensetest.database.model.entities.Question;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
@Dao
public interface QuestionDao {

    @Insert
    long insert(Question question);

    @Query("delete from question")
    void deleteAll();

    @Query("select * from question where id = :questionId")
    Question loadQuestionById(Long questionId);

    @Query("select question.id from question " +
            " inner join categoryQuestion on question.id = categoryQuestion.questionId " +
            " where categoryQuestion.categoryId = :categoryId")
    List<Long> findIdsByCategoryId(long categoryId);

    @Query("select * from question " +
            " inner join categoryQuestion on question.id = categoryQuestion.questionId " +
            " where categoryQuestion.categoryId = :categoryId " +
            " limit :limit")
    List<Question> findByCategoryId(long categoryId, int limit);
}
