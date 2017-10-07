package com.dfirago.dlt.common.database;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
public interface QuestionRepository {
    List<AbstractQuestion> loadQuestions(Category category);

    // TODO real shuffle and SelectionConfig
    List<AbstractQuestion> shuffleQuestions(Category category);
}
