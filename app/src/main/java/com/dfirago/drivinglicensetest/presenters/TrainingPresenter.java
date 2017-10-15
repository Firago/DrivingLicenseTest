package com.dfirago.drivinglicensetest.presenters;

import android.util.Log;

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

    private static final String TAG = "TrainingPresenter";

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
        Log.i(TAG, "Starting training");
        questions = questionDao.loadQuestions(categoryType);
        showQuestion(questions, currentQuestionPos);
    }

    public void onPreviousClicked() {
        Log.i(TAG, "onPreviousClicked() - previous question will be shown");
        currentQuestionPos -= currentQuestionPos > 0 ? 1 : 0;
        showQuestion(questions, currentQuestionPos);
    }

    public void onNextClicked() {
        Log.i(TAG, "onNextClicked() - previous question will be shown");
        currentQuestionPos += currentQuestionPos < (questions.size() - 1) ? 1 : 0;
        showQuestion(questions, currentQuestionPos);
    }

    public void onHintClicked() {
        Log.i(TAG, "onHintClicked() - Correct answer will be highlighted");
        Question currentQuestion = questions.get(currentQuestionPos);
        view.showAnswer(currentQuestion);
    }

    private void showQuestion(List<Question> questions, int index) {
        Log.i(TAG, "Showing question " + (index + 1) + " of " + questions.size());
        view.showQuestion(questions.get(index));
        view.updateQuestionNumber(index + 1, questions.size());
    }
}
