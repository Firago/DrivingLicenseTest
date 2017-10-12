package com.dfirago.dlt.presenters;

import com.dfirago.dlt.common.database.QuestionRepository;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.common.model.Question;
import com.dfirago.dlt.views.TrainingView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingPresenter {

    private List<Question> questions;
    private int currentQuestionPos = 0;

    private TrainingView view;
    private QuestionRepository questionRepository;

    @Inject
    public TrainingPresenter(TrainingView view, QuestionRepository questionRepository) {
        this.view = view;
        this.questionRepository = questionRepository;
    }

    public void startTraining(Category category) {
        questions = questionRepository.shuffleQuestions(category);
        view.showQuestion(questions.get(currentQuestionPos));
    }
}
