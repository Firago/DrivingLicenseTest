package com.dfirago.dlt.fragments.questions.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragments.questions.AbstractQuestionFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionFragmentFactory {

    private final Map<Class<? extends AbstractQuestion>, AbstractQuestionFragmentFactory> factoryMapping;

    public QuestionFragmentFactory(Map<Class<? extends AbstractQuestion>, AbstractQuestionFragmentFactory> factoryMapping) {
        this.factoryMapping = factoryMapping;
    }

    public static QuestionFragmentFactoryBuilder builder() {
        return new QuestionFragmentFactoryBuilder();
    }

    public AbstractQuestionFragment createFragment(AbstractQuestion question) {
        Class<? extends AbstractQuestion> questionClass = question.getClass();
        AbstractQuestionFragmentFactory fragmentFactory = factoryMapping.get(questionClass);
        if (fragmentFactory == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + questionClass.getName());
        }
        return fragmentFactory.createFragment(question);
    }

    public static class QuestionFragmentFactoryBuilder {

        private final Map<Class<? extends AbstractQuestion>,
                AbstractQuestionFragmentFactory> factoryMapping = new HashMap<>();

        public QuestionFragmentFactoryBuilder registerMapping(
                Class<? extends AbstractQuestion> key, AbstractQuestionFragmentFactory value) {
            factoryMapping.put(key, value);
            return QuestionFragmentFactoryBuilder.this;
        }

        public QuestionFragmentFactory build() {
            return new QuestionFragmentFactory(factoryMapping);
        }
    }
}
