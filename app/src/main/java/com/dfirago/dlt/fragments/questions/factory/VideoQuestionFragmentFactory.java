package com.dfirago.dlt.fragments.questions.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragments.questions.VideoQuestionFragment;
import com.google.gson.Gson;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class VideoQuestionFragmentFactory extends AbstractQuestionFragmentFactory<VideoQuestionFragment> {

    public VideoQuestionFragmentFactory(Gson gson) {
        super(gson);
    }

    @Override
    public VideoQuestionFragment createFragment(AbstractQuestion question) {
        VideoQuestionFragment fragment = new VideoQuestionFragment();
        fragment.setArguments(createBundle(question));
        return fragment;
    }
}
