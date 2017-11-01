package com.dfirago.drivinglicensetest.database.model.types;

import com.dfirago.drivinglicensetest.database.model.entities.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/27/2017.
 */
public class ExamStats {

    private int score = 0;
    private int totalPoints = 0;

    private Map<Question, ResponseOption> selectedAnswers = new HashMap<>();

    public ExamStats(List<Question> questions) {
        for (Question question : questions) {
            selectedAnswers.put(question, null);
            totalPoints += question.getPoints();
        }
    }

    public void put(Question question, ResponseOption option) {
        ResponseOption correctOption = question.getCorrectOption();
        if (option != null && option.equals(correctOption)) score += question.getPoints();
        selectedAnswers.put(question, option);
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
