package com.dfirago.drivinglicensetest.common.widget.factories;

import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.builders.AbstractQuestionViewBuilder;

import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionViewFactory {

    private final Map<QuestionType, AbstractQuestionViewBuilder> builderMapping;

    public QuestionViewFactory(Map<QuestionType, AbstractQuestionViewBuilder> builderMapping) {
        this.builderMapping = builderMapping;
    }

    public AbstractQuestionView createView(Question question, ViewGroup.LayoutParams layoutParams) {
        AbstractQuestionViewBuilder viewBuilder = builderMapping.get(question.getType());
        if (viewBuilder == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + question.getType());
        }
        return viewBuilder.buildView(question, layoutParams);
    }
}
