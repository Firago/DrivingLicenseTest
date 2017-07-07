package com.dfirago.dlt.question.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dfirago.dlt.question.common.model.AbstractQuestion;
import com.google.gson.Gson;

public abstract class AbstractQuestionFragment<T extends AbstractQuestion> extends Fragment {

    public static final String QUESTION_PARAM = "question";

    protected static final Gson gsonMapper = new Gson(); // TODO find better place, maybe inject with dagger?

    protected T question;

    protected OnFragmentInteractionListener interactionListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = gsonMapper.fromJson(getArguments()
                    .getString(QUESTION_PARAM), getQuestionClass());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            interactionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
    }

    public interface OnFragmentInteractionListener {

    }

    public abstract Class<T> getQuestionClass();
}
