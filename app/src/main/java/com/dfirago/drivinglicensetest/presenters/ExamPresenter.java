package com.dfirago.drivinglicensetest.presenters;

import com.dfirago.drivinglicensetest.common.database.QuestionService;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.views.ExamView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
@FragmentScope
public class ExamPresenter {

    private List<Question> questions;
    private int currentQuestionPos = 0;

    private ExamView view;
    private QuestionService questionService;

    @Inject
    public ExamPresenter(ExamView view, QuestionService questionService) {
        this.view = view;
        this.questionService = questionService;
    }

    public void loadQuestions(CategoryType categoryType) {
        questions = questionService.shuffleQuestions(categoryType);
        view.showQuestion(questions.get(currentQuestionPos));
    }
}
