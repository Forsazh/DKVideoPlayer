package com.dueeeke.dkplayer.util.cache;

import com.danikula.videocache.HttpProxyCacheServer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;

public class PreloadTask implements Runnable {
    public String mRawUrl;
    public int mPosition;
    public HttpProxyCacheServer mCacheServer;
    private boolean mIsCanceled;
    private boolean mIsExecuted;

    @Override
    public void run() {
        if (!mIsCanceled) start();
        mIsExecuted = false;
        mIsCanceled = false;
    }

    private void start() {
        HttpURLConnection connection = null;
        try {
            String proxyUrl = mCacheServer.getProxyUrl(mRawUrl);
            URL url = new URL(proxyUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5_000);
            connection.setReadTimeout(5_000);
            InputStream in = new BufferedInputStream(connection.getInputStream());
            int length;
            int read = -1;
            byte[] bytes = new byte[8 * 1024];
            while ((length = in.read(bytes)) != -1) {
                read += length;
                if (mIsCanceled || read >= PreloadManager.PRELOAD_LENGTH) break;
            }
            if (read == -1) {
                File cacheFile = mCacheServer.getCacheFile(mRawUrl);
                if (cacheFile.exists()) cacheFile.delete();
            }
        } catch (Exception ignored) {
        } finally {
            if (connection != null) connection.disconnect();
        }
    }

    public void executeOn(ExecutorService executorService) {
        if (mIsExecuted) return;
        mIsExecuted = true;
        executorService.submit(this);
    }

    public void cancel() {
        if (mIsExecuted) mIsCanceled = true;
    }
}
