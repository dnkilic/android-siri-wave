package com.dnkilic.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.dnkilic.waveform.WaveView;


public class MainActivity extends AppCompatActivity {

    WaveView vw2;
    float width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vw2 = (WaveView) findViewById(R.id.vw2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
    }

   public void stop(View v)
   {
       vw2.stopWaveform();
   }

    public void start(View v)
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        vw2.startWaveform(dm);
    }

    public void increase(View v)
    {
        vw2.increaseWaveformAmplitude();
    }

    public void decrease(View v)
    {
        vw2.decreaseWaveformAmplitude();
    }

    public void minimize(View v)
    {
        vw2.minimizeWaveformAmplitude();
    }

}
