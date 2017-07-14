package com.dfirago.dlt.question.data;

import android.content.res.AssetManager;

import com.dfirago.dlt.question.model.AbstractQuestion;
import com.dfirago.dlt.utils.QuestionGsonMapperFactory;
import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionRepository {

    private final AssetManager assetManager;

    public QuestionRepository(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public List<AbstractQuestion> loadQuestions() {
        try {
            InputStream questionsInputStream = assetManager.open("questions.json");
            String questionsJson = IOUtils.toString(questionsInputStream, StandardCharsets.UTF_8);
            Gson gsonMapper = QuestionGsonMapperFactory.getMapper();
            return Arrays.asList(gsonMapper.fromJson(questionsJson, AbstractQuestion[].class));
        } catch (IOException e) {
            throw new RuntimeException("This should never happen - file is delivered as a part of .apk", e);
        }
    }
}
