package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.model.ResponseOption;
import com.dfirago.drivinglicensetest.common.widget.utils.OnOptionSelectionChangeListener;
import com.dfirago.drivinglicensetest.common.widget.utils.OptionsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public abstract class AbstractQuestionView extends LinearLayout {

    @BindView(R.id.question_value)
    TextView questionValueView;

    @BindView(R.id.response_options)
    RecyclerView responseOptionsView;

    private OptionsAdapter optionsAdapter;

    public AbstractQuestionView(Context context) {
        super(context);
        inflateView();
    }

    protected abstract void inflateView();

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        optionsAdapter = new OptionsAdapter();
        responseOptionsView.setAdapter(optionsAdapter);
        responseOptionsView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
    }

    public void setQuestionValue(String questionValue) {
        questionValueView.setText(questionValue);
    }

    public void setOptions(List<ResponseOption> options) {
        optionsAdapter.setData(options);
        optionsAdapter.notifyDataSetChanged();
    }

    public void setOptionSelectionChangeListener(OnOptionSelectionChangeListener listener) {
        optionsAdapter.setOptionSelectionChangeListener(listener);
    }

    public void validate(ResponseOption responseOption) {
        optionsAdapter.validate(responseOption);
    }

    public void reset(ResponseOption responseOption) {
        optionsAdapter.reset(responseOption);
    }

    public void showAnswer() {
        optionsAdapter.showAnswer();
    }
}
