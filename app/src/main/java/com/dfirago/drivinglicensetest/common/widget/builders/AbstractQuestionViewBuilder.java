package com.dfirago.drivinglicensetest.common.widget.builders;

import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;
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
    public T buildView(Question question, ViewGroup.LayoutParams params) {
        Provider<AbstractQuestionView> provider = questionViewProviders.get(question.getType());
        T view = (T) provider.get();
        view.setLayoutParams(params);
        return view;
    }
}
