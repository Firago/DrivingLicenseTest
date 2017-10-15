package com.dfirago.drivinglicensetest.common.widget.listeners;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/15/2017.
 */
public class OnTextureViewTouchListener implements View.OnTouchListener {

    private MediaPlayer mediaPlayer;

    public OnTextureViewTouchListener(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
        return false;
    }
}
