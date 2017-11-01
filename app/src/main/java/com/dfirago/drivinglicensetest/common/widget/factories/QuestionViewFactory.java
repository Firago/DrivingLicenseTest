package com.dfirago.drivinglicensetest.common.widget.factories;

import android.util.Log;
import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.builders.AbstractQuestionViewBuilder;

import java.util.Map;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class QuestionViewFactory {

    public static final String TAG = "QuestionViewFactory";

    private final Map<QuestionType, AbstractQuestionViewBuilder> builderMapping;

    public QuestionViewFactory(Map<QuestionType, AbstractQuestionViewBuilder> builderMapping) {
        this.builderMapping = builderMapping;
    }

    public AbstractQuestionView createView(Question question, ViewGroup.LayoutParams layoutParams) {
        QuestionType type = question.getType();
        Log.d(TAG, "Question type: " + type);
        AbstractQuestionViewBuilder viewBuilder = builderMapping.get(type);
        if (viewBuilder == null) {
            throw new IllegalArgumentException("Mapping not found for question type: " + type);
        }
        return viewBuilder.buildView(question, layoutParams);
    }
}
