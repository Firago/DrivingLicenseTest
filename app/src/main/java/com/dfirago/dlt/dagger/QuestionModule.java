package com.dfirago.dlt.dagger;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.ImageQuestion;
import com.dfirago.dlt.common.model.SimpleQuestion;
import com.dfirago.dlt.common.model.VideoQuestion;
import com.dfirago.dlt.fragment.factory.GenericQuestionFragmentFactory;
import com.dfirago.dlt.fragment.factory.ImageQuestionFragmentFactory;
import com.dfirago.dlt.fragment.factory.SimpleQuestionFragmentFactory;
import com.dfirago.dlt.fragment.factory.VideoQuestionFragmentFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module
public class QuestionModule {

    @Provides
    @Singleton
    GenericQuestionFragmentFactory provideGenericQuestionFragmentFactory() {

        return GenericQuestionFragmentFactory.builder()
                .registerMapping(SimpleQuestion.class, new SimpleQuestionFragmentFactory())
                .registerMapping(ImageQuestion.class, new ImageQuestionFragmentFactory())
                .registerMapping(VideoQuestion.class, new VideoQuestionFragmentFactory())
                .build();
    }

    @Provides
    @Singleton
    @Named("questionsGsonMapper")
    Gson provideQuestionGsonMapper() {

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
