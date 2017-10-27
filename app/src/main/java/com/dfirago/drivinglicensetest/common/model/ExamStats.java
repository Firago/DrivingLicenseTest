package com.dfirago.drivinglicensetest.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/27/2017.
 */
public class ExamStats {

    private int score = 0;
    private int totalPoints = 0;
    private Map<Question, ResponseOption> selectedAnswers = new HashMap<>();

    public void put(Question question, ResponseOption selectedAnswer) {
        ResponseOption correctOption = question.getCorrectOption();
        score += selectedAnswer.equals(correctOption) ? question.getPoints() : 0;
        totalPoints += question.getPoints();
        selectedAnswers.put(question, selectedAnswer);
    }

    public ResponseOption get(Question question) {
        return selectedAnswers.get(question);
    }

    public int getScore() {
        return score;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
