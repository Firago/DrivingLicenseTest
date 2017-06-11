package com.dfirago.dlt.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.adapters.DashboardAdapter;
import com.dfirago.dlt.dashboard.model.DashboardItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardView {

    @BindView(R.id.dashboard_recycler_view)
    protected RecyclerView dashboardRecyclerView;

    private DashboardAdapter dashboardAdapter;
    private DashboardPresenter dashboardPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        dashboardAdapter = new DashboardAdapter();
        dashboardPresenter = new DashboardPresenter();

        final GridLayoutManager layoutManager
                = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);

        dashboardRecyclerView.setAdapter(dashboardAdapter);
        dashboardRecyclerView.setLayoutManager(layoutManager);
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
    public void showDashboard(List<DashboardItem> items) {
        dashboardAdapter.setData(items);
        dashboardAdapter.notifyDataSetChanged();
    }
}
