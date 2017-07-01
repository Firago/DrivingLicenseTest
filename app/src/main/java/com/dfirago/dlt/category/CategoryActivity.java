package com.dfirago.dlt.category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dfirago.dlt.R;
import com.dfirago.dlt.training.TrainingActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryActivity extends AppCompatActivity {

    public static Intent getIntent(Activity callingActivity) {
        return new Intent(callingActivity, CategoryActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.item_training)
    public void onTrainingItemClicked() {
        startActivity(TrainingActivity.getIntent(this));
    }

    @OnClick(R.id.item_assignment)
    public void onExamItemClicked() {
        startActivity(TrainingActivity.getIntent(this));
    }
}
