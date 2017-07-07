package com.dfirago.dlt.utils;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class AssetReader {

    private final AssetManager assetManager;

    public AssetReader(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public Drawable readDrawable(String fileName) {
        try {
            InputStream is = assetManager.open("images/" + fileName);
            return Drawable.createFromStream(is, null);
        } catch (IOException e) {
            return null;
        }
    }
}
