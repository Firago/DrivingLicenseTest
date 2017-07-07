package com.dfirago.dlt.question.image.fragment;

import com.dfirago.dlt.question.common.fragment.AbstractQuestionFragment;
import com.dfirago.dlt.question.image.model.ImageQuestion;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class ImageQuestionFragment extends AbstractQuestionFragment<ImageQuestion> {

    @Override
    public Class<ImageQuestion> getQuestionClass() {
        return ImageQuestion.class;
    }
}
