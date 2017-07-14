package com.dfirago.dlt.question.fragment;

import com.dfirago.dlt.question.model.VideoQuestion;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionFragment  extends AbstractQuestionFragment<VideoQuestion> {

    @Override
    public Class<VideoQuestion> getQuestionClass() {
        return VideoQuestion.class;
    }
}
