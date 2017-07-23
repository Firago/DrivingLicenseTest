package com.dfirago.dlt.navigation;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Dmytro Firago on 14/07/2017.
 */
public interface FragmentOrchestrator {

    void setHeader(Fragment fragment);

    void setContent(Fragment fragment);

    void setFooter(Fragment fragment);

    void startActivity(Intent intent);
}
