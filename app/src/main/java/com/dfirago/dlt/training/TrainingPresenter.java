package com.dfirago.dlt.training;

import com.dfirago.dlt.BasePresenter;

/**
 * Created by Dmytro Firago on 11/06/2017.
 */
public class TrainingPresenter extends BasePresenter<TrainingView> {

    @Override
    protected Class viewClass() {
        return TrainingView.class;
    }
}
