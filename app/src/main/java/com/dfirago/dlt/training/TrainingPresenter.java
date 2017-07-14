package com.dfirago.dlt.training;

import com.dfirago.dlt.BasePresenter;
import com.dfirago.dlt.question.data.QuestionRepository;
import com.dfirago.dlt.question.model.AbstractQuestion;

import java.util.List;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingPresenter extends BasePresenter<TrainingView> {

    private final QuestionRepository questionRepository;

    private List<AbstractQuestion> questions;
    private int currentQuestionPos = 0;

    public TrainingPresenter(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    protected Class viewClass() {
        return TrainingView.class;
    }

    public void startTraining() {
        questions = questionRepository.loadQuestions();
        view().showQuestion(questions.get(currentQuestionPos));
    }
}
