package com.dnkilic.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.dnkilic.waveform.WaveView;

public class MainActivity extends AppCompatActivity {

    private WaveView mWaveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWaveView = (WaveView) findViewById(R.id.vw2);
    }

    public void reset(View v)
    {
        mWaveView.stop();
    }

    public void start(View v)
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mWaveView.initialize(dm);
    }

    public void startSpeech(View v)
    {
        mWaveView.speechStarted();
    }

    public void endSpeech(View v)
    {
        mWaveView.speechEnded();
    }

    public void pauseSpeech(View v)
    {
        mWaveView.speechPaused();
    }
}
