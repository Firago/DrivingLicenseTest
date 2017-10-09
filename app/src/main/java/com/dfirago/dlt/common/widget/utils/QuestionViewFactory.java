package com.dfirago.dlt.common.widget.utils;

import android.content.Context;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.builders.QuestionViewBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionViewFactory {

    private final Map<Class<? extends AbstractQuestion>, QuestionViewBuilder> viewMapping;

    public QuestionViewFactory(Map<Class<? extends AbstractQuestion>, QuestionViewBuilder> viewMapping) {
        this.viewMapping = viewMapping;
    }

    public static QuestionViewFactoryBuilder builder() {
        return new QuestionViewFactoryBuilder();
    }

    public AbstractQuestionView createView(Context context, AbstractQuestion question) {
        Class<? extends AbstractQuestion> questionClass = question.getClass();
        QuestionViewBuilder viewFactory = viewMapping.get(questionClass);
        if (viewFactory == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + questionClass.getName());
        }
        return viewFactory.buildView(context, question);
    }

    public static class QuestionViewFactoryBuilder {

        private final Map<Class<? extends AbstractQuestion>,
                QuestionViewBuilder> factoryMapping = new HashMap<>();

        public QuestionViewFactoryBuilder registerMapping(
                Class<? extends AbstractQuestion> key, QuestionViewBuilder value) {
            factoryMapping.put(key, value);
            return QuestionViewFactoryBuilder.this;
        }

        public QuestionViewFactory build() {
            return new QuestionViewFactory(factoryMapping);
        }
    }
}
