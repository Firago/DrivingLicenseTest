package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import com.dfirago.drivinglicensetest.R;
import com.dfirago.drivinglicensetest.common.widget.listeners.AbstractSurfaceTextureListener;
import com.dfirago.drivinglicensetest.common.widget.listeners.OnMediaPlayerPreparedListener;
import com.dfirago.drivinglicensetest.common.widget.listeners.OnTextureViewTouchListener;
import com.dfirago.drivinglicensetest.common.widget.utils.OptionsAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/8/2017.
 */
public class VideoQuestionView extends AbstractQuestionView {

    private static final String TAG = "VideoQuestionView";

    private MediaPlayer mediaPlayer;

    @BindView(R.id.question_video)
    TextureView textureView;

    @Inject
    public VideoQuestionView(Context context, OptionsAdapter optionsAdapter) {
        super(context, optionsAdapter);
    }

    @Override
    protected void inflateView() {
        View.inflate(getContext(), R.layout.view_video_question, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setQuestionVideo(AssetFileDescriptor afd) {
        mediaPlayer = new MediaPlayer();
        textureView.setOnTouchListener(new OnTextureViewTouchListener(mediaPlayer));
        textureView.setSurfaceTextureListener(new AbstractSurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
                Surface surface = new Surface(surfaceTexture);
                try {
                    mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mediaPlayer.setSurface(surface);
                    mediaPlayer.prepare();
                    mediaPlayer.setOnPreparedListener(new OnMediaPlayerPreparedListener(textureView));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDetachedFromWindow();
    }
}
