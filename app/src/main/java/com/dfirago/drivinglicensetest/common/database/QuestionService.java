package com.dfirago.drivinglicensetest.common.database;

import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
public interface QuestionService {

    void removeAll();
    
    List<Question> loadQuestions(CategoryType categoryType);

    List<Question> shuffleQuestions(CategoryType categoryType);

    void put(Question question);
}
