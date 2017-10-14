package com.dfirago.drivinglicensetest.common.widget.utils;

import com.dfirago.drivinglicensetest.common.model.ResponseOption;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public interface OnOptionSelectionChangeListener {
    void onOptionSelectionChange(ResponseOption option, boolean isChecked);
}
