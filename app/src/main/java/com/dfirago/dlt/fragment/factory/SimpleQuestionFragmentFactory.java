package com.dfirago.dlt.fragment.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragment.SimpleQuestionFragment;

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
