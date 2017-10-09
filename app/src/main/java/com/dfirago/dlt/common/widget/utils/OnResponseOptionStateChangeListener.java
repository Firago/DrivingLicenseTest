package com.dfirago.dlt.common.widget.utils;

import com.dfirago.dlt.common.model.ResponseOption;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public interface OnResponseOptionStateChangeListener {
    void onResponseOptionStateChanged(ResponseOption option, boolean isChecked);
}
