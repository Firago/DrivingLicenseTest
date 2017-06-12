package com.dfirago.dlt.dashboard;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.adapters.DashboardAdapter;
import com.dfirago.dlt.dashboard.model.DashboardItem;
import com.dfirago.dlt.training.TrainingActivity;
import com.dfirago.dlt.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardView {

    @BindView(R.id.dashboard_recycler_view)
    protected RecyclerView dashboardRecyclerView;

    private DashboardPresenter dashboardPresenter;
    private DashboardAdapter dashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        dashboardPresenter = new DashboardPresenter();
        dashboardAdapter = new DashboardAdapter();
        dashboardAdapter.getItemClicks()
                .subscribe(dashboardPresenter::onItemClicked);
        dashboardRecyclerView.setAdapter(dashboardAdapter);
        dashboardRecyclerView.setLayoutManager(new GridLayoutManager(
                this, Constants.DASHBOARD_SPAN, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();
        dashboardPresenter.attachView(this);
        dashboardPresenter.loadDashboard();
    }

    @Override
    protected void onPause() {
        dashboardPresenter.detachView();
        super.onPause();
    }

    @Override
    public void showItems(List<DashboardItem> items) {
        dashboardAdapter.setData(items);
        dashboardAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCategoryItemClicked() {
        dashboardPresenter.loadCategoryOptions();
    }

    @Override
    public void onTrainingItemClicked() {
        startActivity(TrainingActivity.getIntent(this));
    }

    @Override
    public void onExamItemClicked() {
        startActivity(TrainingActivity.getIntent(this)); // TODO
    }

    @Override
    public void onRateItemClicked() {
        try {
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }
}
