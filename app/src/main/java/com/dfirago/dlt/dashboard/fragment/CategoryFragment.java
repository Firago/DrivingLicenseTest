package com.dfirago.dlt.dashboard.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfirago.dlt.R;
import com.dfirago.dlt.common.CategoryType;
import com.dfirago.dlt.common.TestMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends Fragment {

    private static final String ARG_CATEGORY_TYPE = "category_type";

    private CategoryType category;

    private OnFragmentInteractionListener interactionListener;

    public static CategoryFragment newInstance(CategoryType category) {
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
            category = CategoryType.valueOf(categoryType);
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
            interactionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
    }

    @OnClick(R.id.item_training)
    public void onTrainingItemClicked(View view) {
        interactionListener.onModeSelected(category, TestMode.TRAINING);
    }

    @OnClick(R.id.item_exam)
    public void onExamItemClicked(View view) {
        interactionListener.onModeSelected(category, TestMode.EXAM);
    }

    public interface OnFragmentInteractionListener {
        void onModeSelected(CategoryType category, TestMode testMode);
    }
}
