package com.dfirago.drivinglicensetest.views;

import com.dfirago.drivinglicensetest.common.model.Question;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public interface TrainingView {

    void showHeader();

    void showQuestion(Question question);

    void showFooter();

    void showAnswer(Question question);
}
