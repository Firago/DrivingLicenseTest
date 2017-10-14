package com.dfirago.drivinglicensetest.fragments.listeners;

import com.dfirago.drivinglicensetest.common.model.ResponseOption;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.utils.OnOptionSelectionChangeListener;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class TrainingOptionSelectionChangeListener implements OnOptionSelectionChangeListener {

    private AbstractQuestionView questionView;

    public TrainingOptionSelectionChangeListener(AbstractQuestionView questionView) {
        this.questionView = questionView;
    }

    @Override
    public void onOptionSelectionChange(ResponseOption option, boolean isChecked) {
        if (isChecked) {
            questionView.unhighlightAll();
            questionView.highlight(option);
        }
    }
}
