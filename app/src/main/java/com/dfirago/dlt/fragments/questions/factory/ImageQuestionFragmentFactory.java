package com.dfirago.dlt.fragments.questions.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragments.questions.ImageQuestionFragment;
import com.google.gson.Gson;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionFragmentFactory extends AbstractQuestionFragmentFactory<ImageQuestionFragment> {

    public ImageQuestionFragmentFactory(Gson gson) {
        super(gson);
    }

    @Override
    public ImageQuestionFragment createFragment(AbstractQuestion question) {
        ImageQuestionFragment fragment = new ImageQuestionFragment();
        fragment.setArguments(createBundle(question));
        return fragment;
    }
}
