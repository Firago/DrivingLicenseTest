package com.dfirago.drivinglicensetest.common.widget.builders;

import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;

import java.util.Map;

import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public abstract class AbstractQuestionViewBuilder<T extends AbstractQuestionView> {

    private Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders;

    protected AbstractQuestionViewBuilder(Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders) {
        this.questionViewProviders = questionViewProviders;
    }

    @SuppressWarnings("unchecked")
    public T buildView(Question question) {
        Provider<AbstractQuestionView> provider = questionViewProviders.get(question.getType());
        return (T) provider.get();
    }
}
