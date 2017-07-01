package com.dfirago.dlt.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dfirago.dlt.R;
import com.dfirago.dlt.category.CategoryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.button_category_a,
            R.id.button_category_b,
            R.id.button_category_c,
            R.id.button_category_d,
            R.id.button_category_t
    })
    public void onCategoryItemClicked() {
        startActivity(CategoryActivity.getIntent(this));
    }

    @OnClick(R.id.button_rate_app)
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
