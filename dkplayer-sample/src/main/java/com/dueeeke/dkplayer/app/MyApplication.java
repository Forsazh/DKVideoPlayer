package com.dueeeke.dkplayer.app;

import android.app.Application;

import com.dueeeke.videoplayer.BuildConfig;
import com.dueeeke.videoplayer.exo.ExoMediaPlayerFactory;
import com.dueeeke.videoplayer.player.VideoViewConfig;
import com.dueeeke.videoplayer.player.VideoViewManager;

/**
 * Created by dueeeke on 2017/4/22.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VideoViewManager.setConfig(VideoViewConfig.newBuilder()
                .setLogEnabled(BuildConfig.DEBUG)
                .setPlayerFactory(new ExoMediaPlayerFactory())
                .build());
    }
}
