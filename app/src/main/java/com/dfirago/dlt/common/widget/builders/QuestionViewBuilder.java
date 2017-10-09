package com.dfirago.dlt.common.widget.builders;

import android.content.Context;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.widget.AbstractQuestionView;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public interface QuestionViewBuilder<T extends AbstractQuestionView> {

    T buildView(Context context, AbstractQuestion question);
}
