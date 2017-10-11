package com.dfirago.dlt.common.widget.builders;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.SimpleQuestion;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.SimpleQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class SimpleQuestionViewBuilder extends AbstractQuestionViewBuilder<SimpleQuestionView> {

    @Inject
    protected SimpleQuestionViewBuilder(Map<Class<? extends AbstractQuestion>, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
    }

    @Override
    public SimpleQuestionView buildView(AbstractQuestion question) {
        SimpleQuestion simpleQuestion = (SimpleQuestion) question;
        SimpleQuestionView view = super.buildView(question);
        view.setQuestionValue(simpleQuestion.getValue());
        view.setOptions(simpleQuestion.getOptions());
        return view;
    }
}
