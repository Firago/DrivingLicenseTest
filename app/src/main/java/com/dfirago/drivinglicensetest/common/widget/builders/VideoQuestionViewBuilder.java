package com.dfirago.drivinglicensetest.common.widget.builders;

import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.utils.AssetReader;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.VideoQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionViewBuilder extends AbstractQuestionViewBuilder<VideoQuestionView> {

    private AssetReader assetReader;

    @Inject
    protected VideoQuestionViewBuilder(AssetReader assetReader, Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
        this.assetReader = assetReader;
    }

    @Override
    public VideoQuestionView buildView(Question question, ViewGroup.LayoutParams layoutParams) {
        VideoQuestionView view = super.buildView(question, layoutParams);
        // TODO how to pass video?
//        Video video = assetReader.readDrawable(videoQuestion.getVideo());
//        view.setVideo(video);
        view.setQuestionValue(question.getValue());
        view.setOptions(question.getOptions());
        return view;
    }
}
