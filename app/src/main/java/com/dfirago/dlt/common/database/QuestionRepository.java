package com.dfirago.dlt.common.database;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.utils.AssetReader;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionRepository {

    @Inject
    AssetReader assetReader;

    @Inject
    @Named("questionsGsonMapper")
    Gson questionsGsonMapper;

    public List<AbstractQuestion> loadQuestions() {
        String questionsJson = assetReader.readText("questions.json");
        return Arrays.asList(questionsGsonMapper.fromJson(questionsJson, AbstractQuestion[].class));
    }
}
