package com.dfirago.dlt.fragment.factory;

import android.os.Bundle;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragment.AbstractQuestionFragment;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public abstract class AbstractQuestionFragmentFactory<T extends AbstractQuestionFragment> {

    @Inject
    @Named("questionsGsonMapper")
    Gson questionsGsonMapper;

    public abstract T createFragment(AbstractQuestion question);

    protected Bundle createBundle(AbstractQuestion question) {
        Bundle bundle = new Bundle();
        bundle.putString(AbstractQuestionFragment.QUESTION_PARAM,
                questionsGsonMapper.toJson(question));
        return bundle;
    }
}
