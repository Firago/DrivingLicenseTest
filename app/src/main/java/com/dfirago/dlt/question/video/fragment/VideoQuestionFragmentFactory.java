package com.dfirago.dlt.question.video.fragment;

import com.dfirago.dlt.question.common.fragment.AbstractQuestionFragmentFactory;
import com.dfirago.dlt.question.common.model.AbstractQuestion;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionFragmentFactory extends AbstractQuestionFragmentFactory<VideoQuestionFragment> {

    @Override
    public VideoQuestionFragment createFragment(AbstractQuestion question) {
        VideoQuestionFragment fragment = new VideoQuestionFragment();
        fragment.setArguments(createBundle(question));
        return fragment;
    }
}
