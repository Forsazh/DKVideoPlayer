package com.dueeeke.dkplayer.util;

import android.content.Context;

import com.dueeeke.dkplayer.bean.TiktokBean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<TiktokBean> tiktokData;

    public static List<TiktokBean> getTiktokDataFromAssets(Context context) {
        try {
            if (tiktokData == null) {
                InputStream is = context.getAssets().open("tiktok_data");
                int length = is.available();
                byte[] buffer = new byte[length];
                is.read(buffer);
                is.close();
                String result = new String(buffer, Charset.forName("UTF-8"));
                tiktokData = TiktokBean.arrayTiktokBeanFromData(result);
            }
            return tiktokData;
        } catch (IOException ignored) {
        }
        return new ArrayList<>();
    }
}
