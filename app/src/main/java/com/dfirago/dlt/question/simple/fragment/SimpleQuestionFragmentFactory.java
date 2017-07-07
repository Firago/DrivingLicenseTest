package com.dfirago.dlt.question.simple.fragment;

import com.dfirago.dlt.question.common.fragment.AbstractQuestionFragmentFactory;
import com.dfirago.dlt.question.common.model.AbstractQuestion;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class SimpleQuestionFragmentFactory extends AbstractQuestionFragmentFactory<SimpleQuestionFragment> {

    @Override
    public SimpleQuestionFragment createFragment(AbstractQuestion question) {
        SimpleQuestionFragment fragment = new SimpleQuestionFragment();
        fragment.setArguments(createBundle(question));
        return fragment;
    }
}
