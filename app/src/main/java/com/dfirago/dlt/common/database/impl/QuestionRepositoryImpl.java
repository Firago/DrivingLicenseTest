package com.dfirago.dlt.common.database.impl;

import com.dfirago.dlt.common.database.QuestionRepository;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.utils.AssetReader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionRepositoryImpl implements QuestionRepository {

    private final List<AbstractQuestion> questions;

    private AssetReader assetReader;
    private Gson gson;

    @Inject
    public QuestionRepositoryImpl(AssetReader assetReader, Gson gson) {
        this.assetReader = assetReader;
        this.gson = gson;
        this.questions = loadQuestions();
    }

    private List<AbstractQuestion> loadQuestions() {
        String questionsJson = assetReader.readText("questions.json");
        return Arrays.asList(gson.fromJson(questionsJson, AbstractQuestion[].class));
    }

    @Override
    public List<AbstractQuestion> loadQuestions(Category category) {
        List<AbstractQuestion> result = new ArrayList<>();
        for (AbstractQuestion question : questions) {
            List<Category> categories = question.getCategories();
            if (categories.contains(category)) {
                result.add(question);
            }
        }
        return result;
    }

    @Override
    public List<AbstractQuestion> shuffleQuestions(Category category) {
        // TODO real shuffle and SelectionConfig
        List<AbstractQuestion> questions = loadQuestions(category);
        Collections.shuffle(questions);
        return questions.subList(0, 32);
    }
}
