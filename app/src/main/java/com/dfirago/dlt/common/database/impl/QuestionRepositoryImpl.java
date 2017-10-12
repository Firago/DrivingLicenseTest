package com.dfirago.dlt.common.database.impl;

import com.dfirago.dlt.common.database.QuestionRepository;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.Question;
import com.dfirago.dlt.common.utils.AssetReader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/12/2017.
 */
public class QuestionRepositoryImpl implements QuestionRepository {

    private final List<Question> questions;

    private AssetReader assetReader;
    private Gson gson;

    @Inject
    public QuestionRepositoryImpl(AssetReader assetReader, Gson gson) {
        this.assetReader = assetReader;
        this.gson = gson;
        this.questions = loadQuestions();
    }

    private List<Question> loadQuestions() {
        String questionsJson = assetReader.readText("questions.json");
        return Arrays.asList(gson.fromJson(questionsJson, Question[].class));
    }

    @Override
    public List<Question> loadQuestions(Category category) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions) {
            List<Category> categories = question.getCategories();
            if (categories.contains(category)) {
                result.add(question);
            }
        }
        return result;
    }

    @Override
    public List<Question> shuffleQuestions(Category category) {
        // TODO real shuffle and SelectionConfig
        List<Question> questions = loadQuestions(category);
        Collections.shuffle(questions);
        return questions.subList(0, 32);
    }
}
