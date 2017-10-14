package com.dfirago.drivinglicensetest.common.widget.factories;

import com.dfirago.drivinglicensetest.common.model.TestMode;
import com.dfirago.drivinglicensetest.common.widget.AbstractFooterView;

import java.util.Map;

import javax.inject.Provider;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/14/2017.
 */
public class FooterViewFactory {

    private final Map<TestMode, Provider<AbstractFooterView>> viewMapping;

    public FooterViewFactory(Map<TestMode, Provider<AbstractFooterView>> viewMapping) {
        this.viewMapping = viewMapping;
    }

    public AbstractFooterView createView(TestMode testMode) {
        Provider<AbstractFooterView> provider = viewMapping.get(testMode);
        if (provider == null) {
            throw new IllegalArgumentException("Mapping not found for test mode: " + testMode);
        }
        return provider.get();
    }
}
