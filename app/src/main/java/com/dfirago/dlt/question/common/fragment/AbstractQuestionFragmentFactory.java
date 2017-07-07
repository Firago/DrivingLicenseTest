package com.dfirago.dlt.question.common.fragment;

import android.os.Bundle;

import com.dfirago.dlt.question.common.model.AbstractQuestion;
import com.dfirago.dlt.utils.QuestionGsonMapperFactory;
import com.google.gson.Gson;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public abstract class AbstractQuestionFragmentFactory<T extends AbstractQuestionFragment> {

    private final Gson gsonMapper = QuestionGsonMapperFactory.getMapper();

    public abstract T createFragment(AbstractQuestion question);

    protected Bundle createBundle(AbstractQuestion question) {
        Bundle bundle = new Bundle(1);
        bundle.putString(AbstractQuestionFragment.QUESTION_PARAM, gsonMapper.toJson(question));
        return bundle;
    }
}
