package com.dnkilic.waveform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WaveView extends WebView {

    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initializeWebSettings();

        setWebChromeClient(new WebChromeClient());
        setBackgroundColor(Color.TRANSPARENT);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);

        loadUrl("file:///android_asset/voicewave.html");
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initializeWebSettings() {
        WebSettings webSetting = getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);
    }

    public void initialize(DisplayMetrics dm) {
        loadUrl("javascript:SW9.setWidth(\"" + dm.widthPixels * 92 / 100 + "\")");
        loadUrl("javascript:SW9.start(\"" + "\")");
    }

    public void stop()
    {
        loadUrl("javascript:SW9.stop(\"" + "\")");

        removeAllViews();

        clearHistory();
        clearCache(true);

        if (Build.VERSION.SDK_INT < 18) {
            clearView();
        } else {
            loadUrl("about:blank");
        }

        freeMemory();
        pauseTimers();

        loadUrl("file:///android_asset/voicewave.html");
    }

    public void speechStarted() {
        loadUrl("javascript:SW9.setAmplitude(\"" + 1 + "\")");
    }

    public void speechEnded() {
        loadUrl("javascript:SW9.setAmplitude(\"" + 0.1 + "\")");
    }

    public void speechPaused() {
        loadUrl("javascript:SW9.setAmplitude(\"" + 0.0 + "\")");
    }
}
