package com.dueeeke.dkplayer.widget.render;

import android.graphics.Bitmap;
import android.view.View;

import androidx.annotation.NonNull;

import com.dueeeke.videoplayer.player.AbstractPlayer;
import com.dueeeke.videoplayer.player.VideoView;
import com.dueeeke.videoplayer.render.IRenderView;

public class TikTokRenderView implements IRenderView {
    private final IRenderView mProxyRenderView;

    TikTokRenderView(@NonNull IRenderView renderView) {
        this.mProxyRenderView = renderView;
    }

    @Override
    public void attachToPlayer(@NonNull AbstractPlayer player) {
        mProxyRenderView.attachToPlayer(player);
    }

    @Override
    public void setVideoSize(int videoWidth, int videoHeight) {
        if (videoWidth > 0 && videoHeight > 0) {
            mProxyRenderView.setVideoSize(videoWidth, videoHeight);
            if (videoHeight > videoWidth) {
                mProxyRenderView.setScaleType(VideoView.SCREEN_SCALE_CENTER_CROP);
            } else {
                mProxyRenderView.setScaleType(VideoView.SCREEN_SCALE_DEFAULT);
            }
        }
    }

    @Override
    public void setVideoRotation(int degree) {
        mProxyRenderView.setVideoRotation(degree);
    }

    @Override
    public void setScaleType(int scaleType) {
    }

    @Override
    public View getView() {
        return mProxyRenderView.getView();
    }

    @Override
    public Bitmap doScreenShot() {
        return mProxyRenderView.doScreenShot();
    }

    @Override
    public void release() {
        mProxyRenderView.release();
    }
}