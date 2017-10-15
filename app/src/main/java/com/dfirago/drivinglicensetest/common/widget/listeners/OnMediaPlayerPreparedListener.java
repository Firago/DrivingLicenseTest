package com.dfirago.drivinglicensetest.common.widget.listeners;

import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/15/2017.
 */
public class OnMediaPlayerPreparedListener implements MediaPlayer.OnPreparedListener {

    private TextureView textureView;

    public OnMediaPlayerPreparedListener(TextureView textureView) {
        this.textureView = textureView;
    }

    @Override
    public void onPrepared(MediaPlayer player) {
        adjustViewHeight(player.getVideoWidth(), player.getVideoHeight());
        player.start();
    }

    private void adjustViewHeight(int videoWidth, int videoHeight) {
        int newHeight = (int) (textureView.getWidth() * ((double) videoHeight / videoWidth));
        LinearLayout.LayoutParams layoutParams = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, newHeight);
        textureView.setLayoutParams(layoutParams);
    }
}
