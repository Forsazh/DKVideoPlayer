package com.dueeeke.dkplayer.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TiktokBean {
    public String coverImgUrl;
    public String title;
    public String videoDownloadUrl;

    public static List<TiktokBean> arrayTiktokBeanFromData(String str) {
        Type listType = new TypeToken<ArrayList<TiktokBean>>() {}.getType();
        return new Gson().fromJson(str, listType);
    }
}
