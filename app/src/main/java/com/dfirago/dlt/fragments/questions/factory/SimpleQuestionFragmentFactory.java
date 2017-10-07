package com.dfirago.dlt.fragments.questions.factory;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragments.questions.SimpleQuestionFragment;
import com.google.gson.Gson;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class SimpleQuestionFragmentFactory extends AbstractQuestionFragmentFactory<SimpleQuestionFragment> {

    public SimpleQuestionFragmentFactory(Gson gson) {
        super(gson);
    }

    @Override
    public SimpleQuestionFragment createFragment(AbstractQuestion question) {
        SimpleQuestionFragment fragment = new SimpleQuestionFragment();
        fragment.setArguments(createBundle(question));
        return fragment;
    }
}
