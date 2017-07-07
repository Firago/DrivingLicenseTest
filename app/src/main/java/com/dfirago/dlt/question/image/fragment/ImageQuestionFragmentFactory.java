package com.dfirago.dlt.question.image.fragment;

import com.dfirago.dlt.question.common.fragment.AbstractQuestionFragmentFactory;
import com.dfirago.dlt.question.common.model.AbstractQuestion;

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
