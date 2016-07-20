package com.dnkilic.androidjavascriptbrotherhood;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView vw;
    float speed = 0.1f;
    float amplitude = 1;
    float width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vw = (WebView) findViewById(R.id.webView);

        WebSettings webSetting = vw.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);

        vw.setWebViewClient(new WebViewClient());
        vw.setBackgroundColor(Color.TRANSPARENT);
        vw.loadUrl("file:///android_asset/voicewave.html");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;

    }

    public void increaseWidth(View v)
    {
        width = width + 200;
        Log.i("AndroidJavascriptBrotherhood", "New Width : " + width);
        vw.loadUrl("javascript:SW9.setWidth(\""  + width + "\")");
    }

    public void decreaseWidth(View v)
    {
        width = width - 200;
        Log.i("AndroidJavascriptBrotherhood", "New Width : " + width);
        vw.loadUrl("javascript:SW9.setWidth(\""  + width + "\")");
    }

   public void stop(View v)
   {
       vw.loadUrl("javascript:SW9.stop(\""  + "\")");


       if (Build.VERSION.SDK_INT < 18) {
           vw.clearView();
       } else {
           vw.loadUrl("about:blank");
       }

       vw.loadUrl("file:///android_asset/voicewave.html");
   }

    public void start(View v)
    {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        vw.loadUrl("javascript:SW9.setWidth(\""  + dm.widthPixels * 92 / 100 + "\")");
        vw.loadUrl("javascript:SW9.start(\""  + "\")");
    }

    public void increaseAmplitude(View v)
    {
        amplitude = amplitude + 0.1f;
        Log.i("AndroidJavascriptBrotherhood", "New Amplitude : " + amplitude);
        vw.loadUrl("javascript:SW9.setAmplitude(\""  + amplitude + "\")");
    }

    public void decreaseAmplitude(View v)
    {
        amplitude = amplitude - 0.1f;
        Log.i("AndroidJavascriptBrotherhood", "New Amplitude : " + amplitude);
        vw.loadUrl("javascript:SW9.setAmplitude(\""  + amplitude + "\")");
    }

    public void increaseSpeed(View v)
    {
        speed = speed + 0.1f;
        Log.i("AndroidJavascriptBrotherhood", "New Speed : " + speed);
        vw.loadUrl("javascript:SW9.setSpeed(\""  + speed + "\")");
    }

    public void decreaseSpeed(View v)
    {
        speed = speed - 0.1f;
        Log.i("AndroidJavascriptBrotherhood", "New Speed : " + speed);
        vw.loadUrl("javascript:SW9.setSpeed(\""  + speed + "\")");
    }
}
