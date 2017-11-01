package com.dfirago.drivinglicensetest.common.widget.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.database.model.types.ResponseOption;
import com.dfirago.drivinglicensetest.common.widget.ResponseOptionButton;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionViewHolder> {

    private final List<ResponseOption> options = new ArrayList<>();
    private final BidiMap<ResponseOption, ResponseOptionButton> optionViewMap = new DualHashBidiMap<>();

    private ResponseOptionButton selectedOptionView;
    private OnOptionSelectionChangeListener optionSelectionChangeListener = (option, isChecked) -> {
        // dummy implementation to avoid null-check
    };

    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_option, parent, false);
        return new OptionViewHolder(view);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public void onBindViewHolder(OptionViewHolder holder, int position) {
        ResponseOption responseOption = options.get(position);
        holder.optionView.setText(responseOption.getValue());
        holder.optionView.setOnCheckedChangeListener(new OnResponseOptionCheckedListener());
        holder.optionView.setOnClickListener(this::checkOption);
        optionViewMap.put(responseOption, holder.optionView);
    }

    /**
     * Listener implementation, which will notify external listener about option selection change
     */
    private class OnResponseOptionCheckedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            ResponseOption option = optionViewMap.inverseBidiMap().get(buttonView);
            optionSelectionChangeListener.onOptionSelectionChange(option, isChecked);
        }
    }

    private void checkOption(View view) {
        if (selectedOptionView == null) {               // nothing is selected
            selectedOptionView = (ResponseOptionButton) view;
            selectedOptionView.setChecked(true);
        } else if (selectedOptionView.equals(view)) {   // selected item clicked
            selectedOptionView.setChecked(false);
            selectedOptionView = null;
        } else {                                        // other than selected item clicked
            selectedOptionView.setChecked(false);
            selectedOptionView = (ResponseOptionButton) view;
            selectedOptionView.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    static class OptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.option_value)
        ResponseOptionButton optionView;

        OptionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setData(List<ResponseOption> data) {
        options.clear();
        optionViewMap.clear();
        options.addAll(data);
    }

    public void setOptionSelectionChangeListener(OnOptionSelectionChangeListener optionViewStateChangeListener) {
        this.optionSelectionChangeListener = optionViewStateChangeListener;
    }

    public void validate(ResponseOption responseOption) {
        ResponseOptionButton optionView = optionViewMap.get(responseOption);
        if (optionView != null) {
            optionView.setValidated(true);
            optionView.setCorrect(responseOption.isCorrect());
        }
    }

    public void reset(ResponseOption responseOption) {
        ResponseOptionButton optionView = optionViewMap.get(responseOption);
        if (optionView != null) {
            optionView.reset();
        }
    }

    public void showAnswer() {
        for (ResponseOption option : options) {
            if (option.isCorrect()) {
                ResponseOptionButton optionView = optionViewMap.get(option);
                checkOption(optionView);
                break;
            }
        }
    }
}
