package com.dfirago.dlt.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.model.Category;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.item_category_a)
    public void onCategoryAItemClicked(View view) {
        mListener.onCategorySelected(Category.A);
    }

    @OnClick(R.id.item_category_b)
    public void onCategoryBItemClicked(View view) {
        mListener.onCategorySelected(Category.B);
    }

    @OnClick(R.id.item_category_c)
    public void onCategoryCItemClicked(View view) {
        mListener.onCategorySelected(Category.C);
    }

    @OnClick(R.id.item_category_d)
    public void onCategoryDItemClicked(View view) {
        mListener.onCategorySelected(Category.D);
    }

    @OnClick(R.id.item_category_t)
    public void onCategoryTItemClicked(View view) {
        mListener.onCategorySelected(Category.T);
    }

    @OnClick(R.id.item_rate_app)
    public void onRateItemClicked() {
        mListener.onRateAppSelected();
    }

    public interface OnFragmentInteractionListener {
        void onCategorySelected(Category category);
        void onRateAppSelected();
    }
}
