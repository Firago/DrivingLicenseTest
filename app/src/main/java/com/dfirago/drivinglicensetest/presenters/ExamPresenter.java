package com.dfirago.drivinglicensetest.presenters;

import android.os.CountDownTimer;
import android.util.Log;

import com.dfirago.drivinglicensetest.common.database.QuestionService;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.ExamStats;
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

    private static final String TAG = "TrainingPresenter";

    private CountDownTimer totalTimer;
    private CountDownTimer questionTimer;

    private List<Question> questions;
    private int currentQuestionPos = 0;
    private ExamStats examStats;

    private ExamView view;
    private QuestionService questionService;

    @Inject
    public ExamPresenter(ExamView view, QuestionService questionService) {
        this.view = view;
        this.questionService = questionService;
    }

    public void startExam(CategoryType categoryType) {
        Log.i(TAG, "Starting training");
        examStats = new ExamStats();
        questions = questionService.shuffleQuestions(categoryType);
        totalTimer = new TotalCountDownTimer(25 * 60 * 1000, 1000);
        questionTimer = new QuestionCountDownTimer(30 * 1000, 1000);
        showQuestion(questions, currentQuestionPos);
        totalTimer.start();
    }

    public void onNextClicked() {
        Log.i(TAG, "onNextClicked() - next question will be shown");
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
            showNextQuestion();
        }
    }
}
