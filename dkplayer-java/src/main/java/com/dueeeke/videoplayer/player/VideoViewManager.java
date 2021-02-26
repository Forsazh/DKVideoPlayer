package com.dueeeke.videoplayer.player;

import java.util.LinkedHashMap;

public class VideoViewManager {
    private final LinkedHashMap<String, VideoView> mVideoViews = new LinkedHashMap<>();
    private final boolean mPlayOnMobileNetwork;
    private static VideoViewManager sInstance;
    private static VideoViewConfig sConfig;

    private VideoViewManager() {
        mPlayOnMobileNetwork = getConfig().mPlayOnMobileNetwork;
    }

    public static void setConfig(VideoViewConfig config) {
        if (sConfig == null) {
            synchronized (VideoViewConfig.class) {
                if (sConfig == null) {
                    sConfig = config == null ? VideoViewConfig.newBuilder().build() : config;
                }
            }
        }
    }

    public static VideoViewConfig getConfig() {
        setConfig(null);
        return sConfig;
    }

    public boolean playOnMobileNetwork() {
        return mPlayOnMobileNetwork;
    }

    public static VideoViewManager instance() {
        if (sInstance == null) {
            synchronized (VideoViewManager.class) {
                if (sInstance == null) sInstance = new VideoViewManager();
            }
        }
        return sInstance;
    }

    public VideoView get(String tag) {
        return mVideoViews.get(tag);
    }
}
