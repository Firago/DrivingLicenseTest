package com.dfirago.drivinglicensetest.common.widget.builders;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.common.expansion.ExpansionFileProvider;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.ImageQuestionView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionViewBuilder extends AbstractQuestionViewBuilder<ImageQuestionView> {

    private ExpansionFileProvider expansionFileProvider;

    @Inject
    protected ImageQuestionViewBuilder(Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders, ExpansionFileProvider expansionFileProvider) {
        super(questionViewProviders);
        this.expansionFileProvider = expansionFileProvider;
    }

    @Override
    public ImageQuestionView buildView(Question question, ViewGroup.LayoutParams layoutParams) {
        try {
            ImageQuestionView view = super.buildView(question, layoutParams);
            InputStream inputStream = expansionFileProvider
                    .getInputStream(question.getMedia());
            view.setQuestionImage(Drawable.createFromStream(inputStream, null));
            view.setQuestionValue(question.getValue());
            view.setOptions(question.getOptions());
            return view;
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Expansion file does not contain image " + question.getMedia());
        }
    }
}
