package com.dfirago.dlt.exam;

import com.dfirago.dlt.BasePresenter;
import com.dfirago.dlt.question.common.data.QuestionRepository;
import com.dfirago.dlt.question.common.model.AbstractQuestion;

import java.util.List;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class ExamPresenter extends BasePresenter<ExamView> {

    private final QuestionRepository questionRepository;

    private List<AbstractQuestion> questions;
    private int currentQuestionPos = 0;

    public ExamPresenter(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    protected Class viewClass() {
        return ExamView.class;
    }

    public void startExam() {
        questions = questionRepository.loadQuestions();
        view().showQuestion(questions.get(currentQuestionPos));
    }
}
