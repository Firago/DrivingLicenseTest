package com.dfirago.dlt.fragments.questions;

import com.dfirago.dlt.common.model.VideoQuestion;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionFragment  extends AbstractQuestionFragment<VideoQuestion> {

    @Override
    public Class<VideoQuestion> getQuestionClass() {
        return VideoQuestion.class;
    }
}
