package com.dfirago.dlt.training.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.dfirago.dlt.R;
import com.dfirago.dlt.training.model.Option;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionViewHolder> {

    private final List<Option> options = new ArrayList<>();

    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_option, parent, false);
        return new OptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OptionViewHolder holder, int position) {
        Option option = options.get(position);
        holder.optionValueView.setText(option.getValue());
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public void setData(List<Option> data) {
        options.clear();
        options.addAll(data);
    }

    static class OptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.option_value)
        ToggleButton optionValueView;

        OptionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
