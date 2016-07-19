package com.dnkilic.androidjavascriptbrotherhood;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    WebView vw;
    float speed = 0.1f;
    float amplitude = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vw = (WebView) findViewById(R.id.webView);

        WebSettings webSetting = vw.getSettings();
        webSetting.setJavaScriptEnabled(true);

        vw.setWebViewClient(new WebViewClient());
        vw.setBackgroundColor(Color.TRANSPARENT);

        vw.loadUrl("file:///android_asset/index.html");
    }

   public void stop(View v)
   {
       vw.loadUrl("javascript:SW9.stop(\""  + "\")");
   }

    public void start(View v)
    {
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
