package com.dfirago.dlt.fragment.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragment.AbstractQuestionFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class GenericQuestionFragmentFactory extends AbstractQuestionFragmentFactory<AbstractQuestionFragment> {

    private final Map<Class<? extends AbstractQuestion>, AbstractQuestionFragmentFactory> factoryMapping;

    public GenericQuestionFragmentFactory(
            Map<Class<? extends AbstractQuestion>, AbstractQuestionFragmentFactory> factoryMapping) {
        this.factoryMapping = factoryMapping;
    }

    public AbstractQuestionFragment createFragment(AbstractQuestion question) {
        Class<? extends AbstractQuestion> questionClass = question.getClass();
        AbstractQuestionFragmentFactory fragmentFactory = factoryMapping.get(questionClass);
        if (fragmentFactory == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + questionClass.getName());
        }
        return fragmentFactory.createFragment(question);
    }

    public static GenericQuestionFragmentFactoryBuilder builder() {
        return new GenericQuestionFragmentFactoryBuilder();
    }

    public static class GenericQuestionFragmentFactoryBuilder {

        private final Map<Class<? extends AbstractQuestion>,
                AbstractQuestionFragmentFactory> factoryMapping = new HashMap<>();

        public GenericQuestionFragmentFactoryBuilder registerMapping(
                Class<? extends AbstractQuestion> key, AbstractQuestionFragmentFactory value) {
            factoryMapping.put(key, value);
            return GenericQuestionFragmentFactoryBuilder.this;
        }

        public GenericQuestionFragmentFactory build() {
            return new GenericQuestionFragmentFactory(factoryMapping);
        }
    }
}
