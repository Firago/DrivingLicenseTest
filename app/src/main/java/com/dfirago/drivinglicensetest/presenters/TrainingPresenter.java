package com.dfirago.drivinglicensetest.presenters;

import android.util.Log;

import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.database.dao.QuestionDao;
import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.views.TrainingView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
@FragmentScope
public class TrainingPresenter {

    private static final String TAG = "TrainingPresenter";

    private List<Long> questionIds;
    private int currentQuestionPos = 1300;

    private TrainingView view;
    private QuestionDao questionDao;

    @Inject
    public TrainingPresenter(TrainingView view, QuestionDao questionDao) {
        this.view = view;
        this.questionDao = questionDao;
    }

    public void startTraining(Category category) {
        Log.i(TAG, "Starting training");
        questionIds = questionDao.findIdsByCategoryId(category.getId());
        showQuestion(questionIds, currentQuestionPos);
    }

    public void onPreviousClicked() {
        Log.i(TAG, "onPreviousClicked() - previous question will be shown");
        int updatedPos = currentQuestionPos - 1;
        if (updatedPos > -1) {
            currentQuestionPos = updatedPos;
            showQuestion(questionIds, currentQuestionPos);
        }
    }

    public void onNextClicked() {
        Log.i(TAG, "onNextClicked() - next question will be shown");
        int updatedPos = currentQuestionPos + 1;
        if (updatedPos < questionIds.size()) {
            currentQuestionPos = updatedPos;
            showQuestion(questionIds, currentQuestionPos);
        }
    }

    public void onHintClicked() {
        Log.i(TAG, "onHintClicked() - Correct answer will be highlighted");
        view.showAnswer();
    }

    private void showQuestion(List<Long> questionIds, int index) {
        Log.i(TAG, "Showing question " + (index + 1) + " of " + questionIds.size());
        Question question = questionDao.loadQuestionById(questionIds.get(index));
        view.showQuestion(question);
        view.updateQuestionNumber(index + 1, questionIds.size());
    }
}
