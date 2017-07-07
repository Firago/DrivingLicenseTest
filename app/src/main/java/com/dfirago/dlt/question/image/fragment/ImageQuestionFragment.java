package com.dfirago.dlt.question.image.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dfirago.dlt.R;
import com.dfirago.dlt.question.common.adapter.OptionsAdapter;
import com.dfirago.dlt.question.common.fragment.AbstractQuestionFragment;
import com.dfirago.dlt.question.common.model.ResponseOption;
import com.dfirago.dlt.question.image.model.ImageQuestion;
import com.dfirago.dlt.utils.AssetReader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago on 14/06/2017.
 */
public class ImageQuestionFragment extends AbstractQuestionFragment<ImageQuestion> {

    @BindView(R.id.question_image)
    protected ImageView questionImageView;

    @BindView(R.id.question_value)
    protected TextView questionValueView;

    @BindView(R.id.options_recycler_view)
    protected RecyclerView optionsRecyclerView;

    private OptionsAdapter optionsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_question, container, false);
        ButterKnife.bind(this, view);
        AssetReader assetReader = new AssetReader(getActivity().getAssets());
        Drawable drawable = assetReader.readDrawable(question.getImage());
        questionImageView.setImageDrawable(drawable);
        questionValueView.setText(question.getValue());
        optionsAdapter = new OptionsAdapter();
        optionsRecyclerView.setAdapter(optionsAdapter);
        optionsRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        showOptions(question.getOptions());
        return view;
    }

    private void showOptions(List<ResponseOption> options) {
        optionsAdapter.setData(options);
        optionsAdapter.notifyDataSetChanged();
    }

    @Override
    public Class<ImageQuestion> getQuestionClass() {
        return ImageQuestion.class;
    }
}
