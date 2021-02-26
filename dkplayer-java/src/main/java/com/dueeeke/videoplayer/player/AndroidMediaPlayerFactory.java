package com.dueeeke.videoplayer.player;

import android.content.Context;

public class AndroidMediaPlayerFactory extends PlayerFactory<AndroidMediaPlayer> {
    @Override
    public AndroidMediaPlayer createPlayer(Context context) {
        return new AndroidMediaPlayer(context);
    }
}
