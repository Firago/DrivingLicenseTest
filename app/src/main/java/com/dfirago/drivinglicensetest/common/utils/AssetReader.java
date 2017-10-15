package com.dfirago.drivinglicensetest.common.utils;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago on 07/07/2017.
 */
public class AssetReader {

    private static final String TAG = "AssetReader";

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
            Log.e(TAG, "Failed to load drawable " + fileName, e);
            return null;
        }
    }

    public String readText(String fileName) {
        try {
            InputStream is = assetManager.open(fileName);
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Log.e(TAG, "Failed to load text file " + fileName, e);
            return null;
        }
    }

    public AssetFileDescriptor readVideo(String fileName) {
        try {
            return assetManager.openFd("videos/" + fileName);
        } catch (IOException e) {
            Log.e(TAG, "Failed to load video file descriptor " + fileName, e);
            return null;
        }
    }
}
