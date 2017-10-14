package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.fragments.CategoryFragment;
import com.dfirago.drivinglicensetest.views.CategoryView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/7/2017.
 */
@Module
public interface CategoryFragmentModule {

    @Binds
    CategoryView categoryView(CategoryFragment categoryFragment);
}
