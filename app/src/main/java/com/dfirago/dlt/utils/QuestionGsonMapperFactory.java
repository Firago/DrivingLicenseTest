package com.dfirago.dlt.utils;

import com.dfirago.dlt.question.model.AbstractQuestion;
import com.dfirago.dlt.question.model.ImageQuestion;
import com.dfirago.dlt.question.model.SimpleQuestion;
import com.dfirago.dlt.question.model.VideoQuestion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

/**
 * Created by Dmytro Firago on 04/07/2017.
 */
public final class QuestionGsonMapperFactory {

    public static Gson getMapper() {

        RuntimeTypeAdapterFactory<AbstractQuestion> abstractQuestionAdapterFactory = RuntimeTypeAdapterFactory
                .of(AbstractQuestion.class)
                .registerSubtype(SimpleQuestion.class)
                .registerSubtype(ImageQuestion.class)
                .registerSubtype(VideoQuestion.class);

        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapterFactory(abstractQuestionAdapterFactory);

        return gsonBuilder.create();
    }
}
