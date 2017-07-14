package com.dfirago.dlt.question.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.dfirago.dlt.R;
import com.dfirago.dlt.question.model.ResponseOption;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionViewHolder> {

    private final List<ResponseOption> options = new ArrayList<>();

    private RadioButton selectedOption;

    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_option, parent, false);
        return new OptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OptionViewHolder holder, int position) {
        ResponseOption option = options.get(position);
        holder.optionView.setText(option.getValue());
        holder.optionView.setOnClickListener(view -> {
            if (selectedOption == null) {               // nothing is selected
                selectedOption = (RadioButton) view;
                selectedOption.setChecked(true);
            } else if (selectedOption.equals(view)) {   // selected item clicked
                selectedOption.setChecked(false);
                selectedOption = null;
            } else {                                    // other than selected item clicked
                selectedOption.setChecked(false);
                selectedOption = (RadioButton) view;
                selectedOption.setChecked(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public void setData(List<ResponseOption> data) {
        options.clear();
        options.addAll(data);
    }

    static class OptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.option_value)
        RadioButton optionView;

        OptionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
