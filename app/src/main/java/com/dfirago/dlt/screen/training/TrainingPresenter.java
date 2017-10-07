package com.dfirago.dlt.screen.training;

import com.dfirago.dlt.common.database.QuestionRepository;
import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.Category;
import com.dfirago.dlt.navigation.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingPresenter extends BasePresenter<TrainingView> {

    @Inject
    QuestionRepository questionRepository;

    private List<AbstractQuestion> questions;
    private int currentQuestionPos = 0;

    public void shuffleQuestions(Category category) {
        questions = questionRepository.shuffleQuestions(category);
        view().showQuestion(questions.get(currentQuestionPos));
    }

    @Override
    protected Class viewClass() {
        return TrainingView.class;
    }
}
