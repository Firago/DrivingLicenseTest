package com.dfirago.dlt.common.widget.builders;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.VideoQuestion;
import com.dfirago.dlt.common.utils.AssetReader;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.VideoQuestionView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionViewBuilder extends AbstractQuestionViewBuilder<VideoQuestionView> {

    private AssetReader assetReader;

    @Inject
    protected VideoQuestionViewBuilder(AssetReader assetReader,
                                       Map<Class<? extends AbstractQuestion>, Provider<AbstractQuestionView>> questionViewProviders) {
        super(questionViewProviders);
        this.assetReader = assetReader;
    }

    @Override
    public VideoQuestionView buildView(AbstractQuestion question) {
        VideoQuestion videoQuestion = (VideoQuestion) question;
        VideoQuestionView view = super.buildView(question);
        // TODO how to pass video?
//        Video video = assetReader.readDrawable(videoQuestion.getVideo());
//        view.setVideo(video);
        view.setQuestionValue(videoQuestion.getValue());
        view.setOptions(videoQuestion.getOptions());
        return view;
    }
}
