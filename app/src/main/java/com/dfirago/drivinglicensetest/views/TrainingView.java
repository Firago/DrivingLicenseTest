package com.dfirago.drivinglicensetest.views;

import com.dfirago.drivinglicensetest.common.model.Question;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public interface TrainingView {

    void showQuestion(Question question);

    void showAnswer(Question question);

    void updateQuestionNumber(int current, int total);
}
