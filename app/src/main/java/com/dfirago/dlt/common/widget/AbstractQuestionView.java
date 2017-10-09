package com.dfirago.dlt.common.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.model.ResponseOption;
import com.dfirago.dlt.common.widget.utils.OnResponseOptionStateChangeListener;
import com.dfirago.dlt.common.widget.utils.OptionsAdapter;

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
        this(context, null);
    }

    public AbstractQuestionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbstractQuestionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateView();
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractQuestionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    public void setQuestionValue(String questionValue) {
        questionValueView.setText(questionValue);
    }

    public void setOptions(List<ResponseOption> options) {
        optionsAdapter.setData(options);
        optionsAdapter.notifyDataSetChanged();
    }

    public void setOptionSelectListener(OnResponseOptionStateChangeListener optionStateChangeListener) {
        optionsAdapter.setOptionStateChangeListener(optionStateChangeListener);
    }
}
