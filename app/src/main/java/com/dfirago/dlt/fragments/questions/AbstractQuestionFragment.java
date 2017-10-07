package com.dfirago.dlt.fragments.questions;

import android.os.Bundle;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragments.BaseFragment;
import com.google.gson.Gson;

public abstract class AbstractQuestionFragment<T extends AbstractQuestion> extends BaseFragment {

    public static final String QUESTION_PARAM = "question";

    protected static final Gson gsonMapper = new Gson(); // TODO find better place, maybe inject with dagger?

    protected T question;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = gsonMapper.fromJson(getArguments()
                    .getString(QUESTION_PARAM), getQuestionClass());
        }
    }

    public abstract Class<T> getQuestionClass();
}
