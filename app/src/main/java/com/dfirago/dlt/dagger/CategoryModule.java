package com.dfirago.dlt.dagger;

import com.dfirago.dlt.screen.category.CategoryPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module
public class CategoryModule {

    @Provides
    @Singleton
    CategoryPresenter provideCategoryPresenter() {
        return new CategoryPresenter();
    }
}
