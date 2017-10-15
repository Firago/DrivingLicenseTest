package com.dfirago.drivinglicensetest.common.widget.builders;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.utils.AssetReader;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.ImageQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionViewBuilder extends AbstractQuestionViewBuilder<ImageQuestionView> {

    private AssetReader assetReader;

    @Inject
    protected ImageQuestionViewBuilder(AssetReader assetReader, Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
        this.assetReader = assetReader;
    }

    @Override
    public ImageQuestionView buildView(Question question, ViewGroup.LayoutParams layoutParams) {
        ImageQuestionView view = super.buildView(question, layoutParams);
        Drawable drawable = assetReader.readDrawable(question.getMedia());
        view.setQuestionImage(drawable);
        view.setQuestionValue(question.getValue());
        view.setOptions(question.getOptions());
        return view;
    }
}
