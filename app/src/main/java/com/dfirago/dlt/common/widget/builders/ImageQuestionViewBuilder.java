package com.dfirago.dlt.common.widget.builders;

import android.graphics.drawable.Drawable;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.ImageQuestion;
import com.dfirago.dlt.common.utils.AssetReader;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.ImageQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionViewBuilder extends AbstractQuestionViewBuilder<ImageQuestionView> {

    private AssetReader assetReader;

    @Inject
    protected ImageQuestionViewBuilder(AssetReader assetReader,
                                       Map<Class<? extends AbstractQuestion>, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
        this.assetReader = assetReader;
    }

    @Override
    public ImageQuestionView buildView(AbstractQuestion question) {
        ImageQuestion imageQuestion = (ImageQuestion) question;
        ImageQuestionView view = super.buildView(question);
        Drawable drawable = assetReader.readDrawable(imageQuestion.getImage());
        view.setQuestionImage(drawable);
        view.setQuestionValue(imageQuestion.getValue());
        view.setOptions(imageQuestion.getOptions());
        return view;
    }
}
