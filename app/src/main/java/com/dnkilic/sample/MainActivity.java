package com.dnkilic.sample;

/*
Copyright [2016] [Doğan Kılıç]

Licensed under the Apache License, Version 2.0 (the "License")
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import androidx.appcompat.app.AppCompatActivity;
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
        mWaveView = findViewById(R.id.vw2);
    }

    public void reset(View v) {
        mWaveView.stop();
    }

    public void start(View v) {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mWaveView.initialize(dm);
    }

    public void startSpeech(View v) {
        mWaveView.speechStarted();
    }

    public void endSpeech(View v) {
        mWaveView.speechEnded();
    }

    public void pauseSpeech(View v) {
        mWaveView.speechPaused();
    }
}
