package com.dfirago.drivinglicensetest.common.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
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
public class VideoQuestionView extends AbstractQuestionView
        implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener {

    private static final String TAG = "VideoQuestionView";

    private Uri videoUri;
    private MediaPlayer mediaPlayer;

    @BindView(R.id.question_video)
    TextureView textureView;

    @Inject
    public VideoQuestionView(Context context) {
        super(context);
    }

    @Override
    protected void inflateView() {
        Log.d(TAG, "inflateView()");
        View.inflate(getContext(), R.layout.view_video_question, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        Log.d(TAG, "onFinishInflate()");
        super.onFinishInflate();
        ButterKnife.bind(this);
        textureView.setOnTouchListener(new OnTextureViewTouchListener());
        textureView.setSurfaceTextureListener(this);
    }

    public void setQuestionVideo(Uri videoUri) {
        this.videoUri = videoUri;
    }

    @Override
    protected void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow()");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow()");
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDetachedFromWindow();
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Log.d(TAG, "onSurfaceTextureAvailable()");
        Surface surface = new Surface(surfaceTexture);
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getContext(), videoUri);
            mediaPlayer.setSurface(surface);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepare();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
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

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(TAG, "onPrepared()");
        adjustViewHeight(mp.getVideoWidth(), mp.getVideoHeight());
        mp.start();
    }

    private void adjustViewHeight(int videoWidth, int videoHeight) {
        int newHeight = (int) (textureView.getWidth() * ((double) videoHeight / videoWidth));
        LinearLayout.LayoutParams layoutParams = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, newHeight);
        textureView.setLayoutParams(layoutParams);
    }


    private class OnTextureViewTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
            return false;
        }
    }
}
