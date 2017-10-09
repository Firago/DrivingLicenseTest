package com.dfirago.dlt.common.widget.builders;

import android.content.Context;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.SimpleQuestion;
import com.dfirago.dlt.common.widget.SimpleQuestionView;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class SimpleQuestionViewBuilder implements QuestionViewBuilder<SimpleQuestionView> {

    @Override
    public SimpleQuestionView buildView(Context context, AbstractQuestion question) {
        SimpleQuestion simpleQuestion = (SimpleQuestion) question;
        SimpleQuestionView view = new SimpleQuestionView(context);
        view.setQuestionValue(simpleQuestion.getValue());
        view.setOptions(simpleQuestion.getOptions());
        return view;
    }
}
