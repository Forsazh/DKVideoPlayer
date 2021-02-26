package com.dueeeke.dkplayer.util;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

public final class Utils {
    public static void removeViewFormParent(View v) {
        if (v == null) return;
        ViewParent parent = v.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(v);
        }
    }
}
