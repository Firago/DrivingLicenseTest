package com.dfirago.dlt.presenters;

import com.dfirago.dlt.common.database.QuestionRepository;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.Question;
import com.dfirago.dlt.views.ExamView;

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

    public void loadQuestions(Category category) {
        questions = questionRepository.shuffleQuestions(category);
        view.showQuestion(questions.get(currentQuestionPos));
    }
}
