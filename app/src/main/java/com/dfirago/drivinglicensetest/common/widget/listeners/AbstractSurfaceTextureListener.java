package com.dfirago.drivinglicensetest.common.widget.listeners;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/15/2017.
 */
public class AbstractSurfaceTextureListener implements TextureView.SurfaceTextureListener {

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
