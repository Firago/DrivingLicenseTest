package com.dfirago.dlt.question.fragment.factory;

import com.dfirago.dlt.question.model.AbstractQuestion;
import com.dfirago.dlt.question.fragment.ImageQuestionFragment;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class ImageQuestionFragmentFactory extends AbstractQuestionFragmentFactory<ImageQuestionFragment> {

    @Override
    public ImageQuestionFragment createFragment(AbstractQuestion question) {
        ImageQuestionFragment fragment = new ImageQuestionFragment();
        fragment.setArguments(createBundle(question));
        return fragment;
    }
}
