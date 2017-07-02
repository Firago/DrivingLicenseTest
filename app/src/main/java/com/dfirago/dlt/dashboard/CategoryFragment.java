package com.dfirago.dlt.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.dashboard.model.Category;
import com.dfirago.dlt.dashboard.model.TestMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends Fragment {

    private static final String ARG_CATEGORY_TYPE = "category_type";

    private Category mCategory;

    private OnFragmentInteractionListener mListener;

    public static CategoryFragment newInstance(Category category) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY_TYPE, category.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String categoryType = getArguments().getString(ARG_CATEGORY_TYPE);
            mCategory = Category.valueOf(categoryType);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
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

    @OnClick(R.id.item_training)
    public void onTrainingItemClicked(View view) {
        mListener.onTestSelected(mCategory, TestMode.TRAINING);
    }

    @OnClick(R.id.item_assignment)
    public void onAssignmentItemClicked(View view) {
        mListener.onTestSelected(mCategory, TestMode.ASSIGNMENT);
    }

    public interface OnFragmentInteractionListener {
        void onTestSelected(Category category, TestMode testMode);
    }
}
