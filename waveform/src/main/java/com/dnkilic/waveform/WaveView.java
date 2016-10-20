package com.dnkilic.waveform;

/*
Copyright [2016] [Doğan Kılıç]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

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
