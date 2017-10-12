package com.dfirago.dlt.common.database;

import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.Question;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
public interface QuestionRepository {
    
    List<Question> loadQuestions(Category category);

    List<Question> shuffleQuestions(Category category);
}
