package com.dfirago.drivinglicensetest.common.widget.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.model.ResponseOption;
import com.dfirago.drivinglicensetest.common.utils.ColorProvider;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionViewHolder> {

    private final List<ResponseOption> options = new ArrayList<>();
    private final BidiMap<ResponseOption, CompoundButton> optionViewMap = new DualHashBidiMap<>();

    private RadioButton selectedOptionView;
    private OnOptionSelectionChangeListener optionSelectionChangeListener = (option, isChecked) -> {
        // dummy implementation to avoid null-check
    };

    private ColorProvider colorProvider;

    @Inject
    public OptionsAdapter(ColorProvider colorProvider) {
        this.colorProvider = colorProvider;
    }

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
        holder.optionView.setOnClickListener(new OnResponseOptionClickListener());
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

    /**
     * Listener implementation, which handles check/un-check clicks
     */
    private class OnResponseOptionClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (selectedOptionView == null) {               // nothing is selected
                selectedOptionView = (RadioButton) view;
                selectedOptionView.setChecked(true);
            } else if (selectedOptionView.equals(view)) {   // selected item clicked
                selectedOptionView.setChecked(false);
                selectedOptionView = null;
            } else {                                        // other than selected item clicked
                selectedOptionView.setChecked(false);
                selectedOptionView = (RadioButton) view;
                selectedOptionView.setChecked(true);
            }
        }
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    static class OptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.option_value)
        RadioButton optionView;

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

    public void highlight(ResponseOption responseOption) {
        CompoundButton optionView = optionViewMap.get(responseOption);
        if (optionView != null) {
            optionView.setBackgroundColor(responseOption.isCorrect() ?
                    colorProvider.getColor(R.color.colorOptionCorrect) :
                    colorProvider.getColor(R.color.colorOptionWrong));
        }
    }

    public void unhighlight(ResponseOption responseOption) {
        CompoundButton optionView = optionViewMap.get(responseOption);
        if (optionView != null) {
            optionView.setBackgroundColor(0);
        }
    }

    public void unhighlightAll() {
        for (CompoundButton optionView : optionViewMap.values()) {
            optionView.setBackgroundColor(0);
        }
    }

    public void showCorrectAnswer() {
        options.stream().filter(ResponseOption::isCorrect).forEach(this::highlight);
    }
}
