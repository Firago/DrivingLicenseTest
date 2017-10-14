package com.dfirago.drivinglicensetest.common.widget.factories;

import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.builders.AbstractQuestionViewBuilder;

import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionViewFactory {

    private final Map<QuestionType, AbstractQuestionViewBuilder> viewMapping;

    public QuestionViewFactory(Map<QuestionType, AbstractQuestionViewBuilder> viewMapping) {
        this.viewMapping = viewMapping;
    }

    public AbstractQuestionView createView(Question question) {
        AbstractQuestionViewBuilder viewBuilder = viewMapping.get(question.getType());
        if (viewBuilder == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + question.getType());
        }
        return viewBuilder.buildView(question);
    }
}
