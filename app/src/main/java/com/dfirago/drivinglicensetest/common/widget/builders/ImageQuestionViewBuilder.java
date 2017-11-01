package com.dfirago.drivinglicensetest.common.widget.builders;

import android.net.Uri;
import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.common.expansion.ExpansionFileProvider;
import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.ImageQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionViewBuilder extends AbstractQuestionViewBuilder<ImageQuestionView> {

    @Inject
    protected ImageQuestionViewBuilder(Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
    }

    @Override
    public ImageQuestionView buildView(Question question, ViewGroup.LayoutParams layoutParams) {
        ImageQuestionView view = super.buildView(question, layoutParams);
        Uri imageUri = ExpansionFileProvider.getUri(question.getMedia());
        view.setQuestionImage(imageUri);
        view.setQuestionValue(question.getValue());
        view.setOptions(question.getOptions());
        return view;
    }
}
