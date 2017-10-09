package com.dfirago.dlt.common.widget.builders;

import android.content.Context;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.VideoQuestion;
import com.dfirago.dlt.common.utils.AssetReader;
import com.dfirago.dlt.common.widget.VideoQuestionView;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionViewBuilder implements QuestionViewBuilder<VideoQuestionView> {

    private AssetReader assetReader;

    @Inject
    public VideoQuestionViewBuilder(AssetReader assetReader) {
        this.assetReader = assetReader;
    }

    @Override
    public VideoQuestionView buildView(Context context, AbstractQuestion question) {
        VideoQuestion videoQuestion = (VideoQuestion) question;
        VideoQuestionView view = new VideoQuestionView(context);
        // TODO how to pass video?
//        Video video = assetReader.readDrawable(videoQuestion.getVideo());
//        view.setVideo(video);
        view.setQuestionValue(videoQuestion.getValue());
        view.setOptions(videoQuestion.getOptions());
        return view;
    }
}
