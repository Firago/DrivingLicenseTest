package com.dfirago.dlt.fragments.questions.factory;

import android.os.Bundle;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.fragments.questions.AbstractQuestionFragment;
import com.google.gson.Gson;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public abstract class AbstractQuestionFragmentFactory<T extends AbstractQuestionFragment> {

    private Gson gson;

    public AbstractQuestionFragmentFactory(Gson gson) {
        this.gson = gson;
    }

    public abstract T createFragment(AbstractQuestion question);

    protected Bundle createBundle(AbstractQuestion question) {
        Bundle bundle = new Bundle();
        bundle.putString(AbstractQuestionFragment.QUESTION_PARAM, gson.toJson(question));
        return bundle;
    }
}
