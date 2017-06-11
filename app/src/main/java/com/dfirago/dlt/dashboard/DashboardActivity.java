package com.dfirago.dlt.dashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.adapters.DashboardAdapter;
import com.dfirago.dlt.dashboard.model.DashboardItem;
import com.dfirago.dlt.training.TrainingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardView {

    @BindView(R.id.dashboard_recycler_view)
    protected RecyclerView dashboardRecyclerView;

    private DashboardPresenter dashboardPresenter;
    private DashboardAdapter dashboardAdapter;

    private List<DashboardItem> dashboardItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        dashboardPresenter = new DashboardPresenter();
        dashboardAdapter = new DashboardAdapter();

        final GridLayoutManager layoutManager
                = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);

        dashboardRecyclerView.setAdapter(dashboardAdapter);
        dashboardRecyclerView.setLayoutManager(layoutManager);

        initDashboard();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dashboardPresenter.attachView(this);
        showDashboard();
    }

    @Override
    protected void onPause() {
        dashboardPresenter.detachView();
        super.onPause();
    }

    private void initDashboard() {

        dashboardItems.clear();

        dashboardItems.add(new DashboardItem(getString(R.string.dashboard_item_training_title),
                R.drawable.ic_school_white_48dp, "#09A9FF",
                view -> startActivity(TrainingActivity.getIntent(this))));
        dashboardItems.add(new DashboardItem(getString(R.string.dashboard_item_exam_title),
                R.drawable.ic_assignment_white_48dp, "#3E51B1",
                view -> startActivity(TrainingActivity.getIntent(this))));
        dashboardItems.add(new DashboardItem(getString(R.string.dashboard_item_about_us_title),
                R.drawable.ic_help_outline_white_48dp, "#673BB7",
                view -> startActivity(TrainingActivity.getIntent(this))));
        dashboardItems.add(new DashboardItem(getString(R.string.dashboard_item_rate_us_title),
                R.drawable.ic_thumb_up_white_48dp, "#4BAA50",
                view -> startActivity(TrainingActivity.getIntent(this))));
    }

    public void showDashboard() {
        dashboardAdapter.setData(dashboardItems);
        dashboardAdapter.notifyDataSetChanged();
    }
}
