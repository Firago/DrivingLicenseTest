package com.dfirago.dlt.training;

import com.dfirago.dlt.training.model.ImageQuestion;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class ImageQuestionFragment extends QuestionFragment<ImageQuestion> {

    @Override
    public Class<ImageQuestion> getQuestionClass() {
        return ImageQuestion.class;
    }
}
