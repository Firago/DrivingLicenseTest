package com.dfirago.drivinglicensetest.common.widget.builders;

import android.net.Uri;
import android.view.ViewGroup;

import com.dfirago.drivinglicensetest.common.expansion.ExpansionFileProvider;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.VideoQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionViewBuilder extends AbstractQuestionViewBuilder<VideoQuestionView> {

    @Inject
    protected VideoQuestionViewBuilder(Map<QuestionType, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
    }

    @Override
    public VideoQuestionView buildView(Question question, ViewGroup.LayoutParams layoutParams) {
        VideoQuestionView view = super.buildView(question, layoutParams);
        Uri videoUri = ExpansionFileProvider.getUri(question.getMedia());
        view.setQuestionVideo(videoUri);
        view.setQuestionValue(question.getValue());
        view.setOptions(question.getOptions());
        return view;
    }
}
