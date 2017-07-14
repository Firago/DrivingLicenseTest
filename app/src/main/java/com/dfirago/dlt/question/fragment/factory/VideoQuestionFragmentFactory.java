package com.dfirago.dlt.question.fragment.factory;

import com.dfirago.dlt.question.model.AbstractQuestion;
import com.dfirago.dlt.question.fragment.VideoQuestionFragment;

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
