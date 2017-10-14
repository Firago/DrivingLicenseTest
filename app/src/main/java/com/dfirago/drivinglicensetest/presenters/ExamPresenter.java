package com.dfirago.drivinglicensetest.presenters;

import com.dfirago.drivinglicensetest.common.database.QuestionRepository;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.views.ExamView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class ExamPresenter {

    private List<Question> questions;
    private int currentQuestionPos = 0;

    private ExamView view;
    private QuestionRepository questionRepository;

    @Inject
    public ExamPresenter(ExamView view, QuestionRepository questionRepository) {
        this.view = view;
        this.questionRepository = questionRepository;
    }

    public void loadQuestions(CategoryType categoryType) {
        questions = questionRepository.shuffleQuestions(categoryType);
        view.showQuestion(questions.get(currentQuestionPos));
    }
}
