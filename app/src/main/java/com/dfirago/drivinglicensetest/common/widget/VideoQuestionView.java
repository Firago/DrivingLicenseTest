package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dfirago.drivinglicensetest.R;

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
    public VideoQuestionView(Context context) {
        super(context);
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

    private static class OnMediaPlayerPreparedListener implements MediaPlayer.OnPreparedListener {

        private TextureView textureView;

        private OnMediaPlayerPreparedListener(TextureView textureView) {
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

    private static class OnTextureViewTouchListener implements View.OnTouchListener {

        private MediaPlayer mediaPlayer;

        private OnTextureViewTouchListener(MediaPlayer mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
            return false;
        }
    }

    private class AbstractSurfaceTextureListener implements TextureView.SurfaceTextureListener {

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
}
