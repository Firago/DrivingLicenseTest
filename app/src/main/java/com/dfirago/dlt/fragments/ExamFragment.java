package com.dfirago.dlt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.utils.ViewGroupUtils;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.utils.QuestionViewFactory;
import com.dfirago.dlt.presenters.ExamPresenter;
import com.dfirago.dlt.views.ExamView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by firag on 10/7/2017.
 */
public class ExamFragment extends BaseFragment implements ExamView {

    private static final String CATEGORY_PARAM = "category";

    private Category category;

    @BindView(R.id.question_view_container)
    LinearLayout questionViewContainer;

    @Inject
    ExamPresenter examPresenter;
    @Inject
    QuestionViewFactory questionViewFactory;

    public static ExamFragment newInstance(Category category) {
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_PARAM, category.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryArg = getArguments().getString(CATEGORY_PARAM);
            category = Category.valueOf(categoryArg);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        examPresenter.loadQuestions(category);
    }

    @Override
    public void showQuestion(AbstractQuestion question) {
        AbstractQuestionView view = questionViewFactory.createView(question);
        ViewGroupUtils.replaceView(questionViewContainer, view);
    }
}
