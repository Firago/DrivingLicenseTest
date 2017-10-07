package com.dfirago.dlt.common.utils;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class AssetReader {

    private AssetManager assetManager;

    @Inject
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

    public String readText(String fileName) {
        try {
            InputStream is = assetManager.open(fileName);
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }
}
