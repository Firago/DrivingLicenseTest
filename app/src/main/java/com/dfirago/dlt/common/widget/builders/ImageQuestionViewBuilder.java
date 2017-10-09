package com.dfirago.dlt.common.widget.builders;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.ImageQuestion;
import com.dfirago.dlt.common.utils.AssetReader;
import com.dfirago.dlt.common.widget.ImageQuestionView;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionViewBuilder implements QuestionViewBuilder<ImageQuestionView> {

    private AssetReader assetReader;

    @Inject
    public ImageQuestionViewBuilder(AssetReader assetReader) {
        this.assetReader = assetReader;
    }

    @Override
    public ImageQuestionView buildView(Context context, AbstractQuestion question) {
        ImageQuestion imageQuestion = (ImageQuestion) question;
        ImageQuestionView view = new ImageQuestionView(context);
        Drawable drawable = assetReader.readDrawable(imageQuestion.getImage());
        view.setQuestionImage(drawable);
        view.setQuestionValue(imageQuestion.getValue());
        view.setOptions(imageQuestion.getOptions());
        return view;
    }
}
