package com.dfirago.dlt.dagger;

import com.dfirago.dlt.common.utils.AssetReader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmytro Firago on 17/07/2017.
 */
@Module
public class AssetModule {

    @Provides
    @Singleton
    AssetReader provideAssetReader() {
        return new AssetReader();
    }
}
