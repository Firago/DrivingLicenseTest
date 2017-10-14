package com.dfirago.drivinglicensetest.presenters;

import com.dfirago.drivinglicensetest.common.database.QuestionDao;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.views.TrainingView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
@FragmentScope
public class TrainingPresenter {

    private List<Question> questions;
    private int currentQuestionPos = 0;

    private TrainingView view;
    private QuestionDao questionDao;

    @Inject
    public TrainingPresenter(TrainingView view, QuestionDao questionDao) {
        this.view = view;
        this.questionDao = questionDao;
    }

    public void startTraining(CategoryType categoryType) {
        questions = questionDao.shuffleQuestions(categoryType);
        view.showQuestion(questions.get(currentQuestionPos));
        view.showFooter();
    }

    public void onPreviousClicked() {
        currentQuestionPos -= currentQuestionPos > 0 ? 1 : 0;
        view.showQuestion(questions.get(currentQuestionPos));
    }

    public void onNextClicked() {
        currentQuestionPos += currentQuestionPos < (questions.size() - 1) ? 1 : 0;
        view.showQuestion(questions.get(currentQuestionPos));
    }

    public void onHintClicked() {
        Question currentQuestion = questions.get(currentQuestionPos);
        view.showAnswer(currentQuestion);
    }
}
