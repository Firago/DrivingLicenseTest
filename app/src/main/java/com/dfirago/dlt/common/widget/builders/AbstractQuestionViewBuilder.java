package com.dfirago.dlt.common.widget.builders;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.widget.AbstractQuestionView;

import java.util.Map;

import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public abstract class AbstractQuestionViewBuilder<T extends AbstractQuestionView> {

    private Map<Class<? extends AbstractQuestion>, Provider<AbstractQuestionView>> questionViewProviders;

    protected AbstractQuestionViewBuilder(Map<Class<? extends AbstractQuestion>, Provider<AbstractQuestionView>> questionViewProviders) {
        this.questionViewProviders = questionViewProviders;
    }

    @SuppressWarnings("unchecked")
    public T buildView(AbstractQuestion question) {
        Provider<AbstractQuestionView> provider = questionViewProviders.get(question.getClass());
        return (T) provider.get();
    }
}
