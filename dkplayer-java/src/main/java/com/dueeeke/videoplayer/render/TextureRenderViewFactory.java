package com.dueeeke.videoplayer.render;

import android.content.Context;

public class TextureRenderViewFactory extends RenderViewFactory {
    @Override
    public IRenderView createRenderView(Context context) {
        return new TextureRenderView(context);
    }
}
