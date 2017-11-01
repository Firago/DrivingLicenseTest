package com.dfirago.drivinglicensetest.common.widget.builders;

import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.SimpleQuestionView;

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
    public SimpleQuestionView buildView(Question question, ViewGroup.LayoutParams layoutParams) {
        SimpleQuestionView view = super.buildView(question, layoutParams);
        view.setQuestionValue(question.getValue());
        view.setOptions(question.getOptions());
        return view;
    }
}
