package com.dfirago.drivinglicensetest.views;

import com.dfirago.drivinglicensetest.common.model.ExamStats;
import com.dfirago.drivinglicensetest.common.model.Question;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public interface ExamView {

    void showQuestion(Question question);

    void updateQuestionNumber(int current, int total);

    void updateTotalTimer(long timeLeftMillis);

    void updateQuestionTimer(long millisUntilFinished);

    void showResults(ExamStats examStats);
}
