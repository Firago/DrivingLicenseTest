package com.dfirago.dlt.common.widget.utils;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.builders.AbstractQuestionViewBuilder;

import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionViewFactory {

    private final Map<Class<? extends AbstractQuestion>, AbstractQuestionViewBuilder> viewMapping;

    public QuestionViewFactory(Map<Class<? extends AbstractQuestion>, AbstractQuestionViewBuilder> viewMapping) {
        this.viewMapping = viewMapping;
    }

    public AbstractQuestionView createView(AbstractQuestion question) {
        Class<? extends AbstractQuestion> questionClass = question.getClass();
        AbstractQuestionViewBuilder viewFactory = viewMapping.get(questionClass);
        if (viewFactory == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + questionClass.getName());
        }
        return viewFactory.buildView(question);
    }
}
