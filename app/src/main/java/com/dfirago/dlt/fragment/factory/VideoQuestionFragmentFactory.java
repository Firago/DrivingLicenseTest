package com.dfirago.dlt.fragment.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragment.VideoQuestionFragment;

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
