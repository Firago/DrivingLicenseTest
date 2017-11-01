package com.dfirago.drivinglicensetest.presenters;

import android.os.CountDownTimer;
import android.util.Log;

import com.dfirago.drivinglicensetest.database.dao.QuestionDao;
import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.types.ExamStats;
import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.types.ResponseOption;
import com.dfirago.drivinglicensetest.dagger.scopes.FragmentScope;
import com.dfirago.drivinglicensetest.views.ExamView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
@FragmentScope
public class ExamPresenter {

    private static final String TAG = "TrainingPresenter";

    private CountDownTimer totalTimer;
    private CountDownTimer questionTimer;

    private List<Question> questions;
    private int currentQuestionPos = 0;
    private ExamStats examStats;
    private ResponseOption checkedOption;

    private ExamView view;
    private QuestionDao questionDao;

    @Inject
    public ExamPresenter(ExamView view, QuestionDao questionDao) {
        this.view = view;
        this.questionDao = questionDao;
    }

    public void startExam(Category category) {
        Log.i(TAG, "Starting training");
        questions = questionDao.findByCategoryId(category.getId(), 32);
        examStats = new ExamStats(questions);
        totalTimer = new TotalCountDownTimer(25 * 60 * 1000, 1000);
        questionTimer = new QuestionCountDownTimer(30 * 1000, 1000);
        showQuestion(questions, currentQuestionPos);
        totalTimer.start();
    }

    public void onNextClicked() {
        Log.i(TAG, "onNextClicked() - next question will be shown");
        submitAndNext();
    }

    public void checkOption(ResponseOption option) {
        this.checkedOption = option;
    }

    private void submitAndNext() {
        Question question = questions.get(currentQuestionPos);
        examStats.put(question, checkedOption);
        showNextQuestion();
    }

    private void showNextQuestion() {
        int updatedPos = currentQuestionPos + 1;
        if (updatedPos < questions.size()) {
            currentQuestionPos = updatedPos;
            showQuestion(questions, currentQuestionPos);
        } else {
            view.showResults(examStats);
        }
    }

    private void showQuestion(List<Question> questions, int index) {
        Log.i(TAG, "Showing question " + (index + 1) + " of " + questions.size());
        view.showQuestion(questions.get(index));
        view.updateQuestionNumber(index + 1, questions.size());
        questionTimer.start();
    }

    private class TotalCountDownTimer extends CountDownTimer {

        TotalCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            view.updateTotalTimer(millisUntilFinished);
        }

        @Override
        public void onFinish() {
            view.showResults(examStats);
        }
    }

    private class QuestionCountDownTimer extends CountDownTimer {

        QuestionCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            view.updateQuestionTimer(millisUntilFinished);
        }

        @Override
        public void onFinish() {
            submitAndNext();
        }
    }
}
