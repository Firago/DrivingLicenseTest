package com.dfirago.dlt.dashboard.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.model.DashboardItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Dmytro Firago on 10/06/2017.
 */
public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ItemViewHolder> {

    private final List<DashboardItem> data = new ArrayList<>();

    private final PublishSubject<DashboardItem> onClickSubject = PublishSubject.create();

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.grid_item_dashboard, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        DashboardItem item = data.get(position);
        holder.cardView.setOnClickListener(v -> onClickSubject.onNext(item));
        holder.cardView.setCardBackgroundColor(Color.parseColor(item.getColor()));
        holder.titleView.setText(item.getTitle());
        holder.iconView.setImageResource(item.getIconResource());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<DashboardItem> data) {
        this.data.clear();
        this.data.addAll(data);
    }

    public Observable<DashboardItem> getItemClicks() {
        return onClickSubject.share();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.grid_item_card_view)
        CardView cardView;

        @BindView(R.id.grid_item_title)
        TextView titleView;

        @BindView(R.id.grid_item_icon)
        ImageView iconView;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
