package com.dfirago.drivinglicensetest.common.database.impl;

import com.dfirago.drivinglicensetest.common.database.QuestionDao;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/12/2017.
 */
public class QuestionDaoImpl implements QuestionDao {

    private final Box<Question> questionBox;

    @Inject
    public QuestionDaoImpl(BoxStore boxStore) {
        questionBox = boxStore.boxFor(Question.class);
    }

    @Override
    public void removeAll() {
        questionBox.removeAll();
    }

    @Override
    public List<Question> loadQuestions(CategoryType categoryType) {
        return questionBox.query()
                .filter(question -> question.getCategories().hasA(
                        category -> category.getCategoryType() == categoryType))
                .build()
                .find();
    }

    @Override
    public List<Question> shuffleQuestions(CategoryType categoryType) {
        // TODO real shuffle and SelectionConfig
        List<Question> questions = loadQuestions(categoryType);
        Collections.shuffle(questions);
        return questions.subList(0, 32);
    }

    @Override
    public void put(Question question) {
        questionBox.put(question);
    }
}
