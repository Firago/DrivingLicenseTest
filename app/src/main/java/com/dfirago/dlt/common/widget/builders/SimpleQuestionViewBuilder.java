package com.dfirago.dlt.common.widget.builders;

import com.dfirago.dlt.common.model.Question;
import com.dfirago.dlt.common.model.QuestionType;
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
    protected SimpleQuestionViewBuilder(Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
    }

    @Override
    public SimpleQuestionView buildView(Question question) {
        SimpleQuestionView view = super.buildView(question);
        view.setQuestionValue(question.getValue());
        view.setOptions(question.getOptions());
        return view;
    }
}
