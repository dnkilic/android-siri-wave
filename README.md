# android-siri-wave
Android Siri Wave

Android WebView which can act as iOS9 SiriWave

![](screenshots/intro.gif)


### Integration

The lib is available on jCentral, you can find it with [Gradle, please]

```
dependencies {
    compile 'com.dnkilic.waveform:waveform:0.9.3'
}
```
### Usage

```
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="2"
        android:gravity="center">

        <com.dnkilic.waveform.WaveView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            waveview:deneme="true"
            android:id="@+id/waveview">
        </com.dnkilic.waveform.WaveView>
    </LinearLayout>
```
Methods:
initialize(DisplayMetrics dm)
speechStarted()
speechEnded()
speechPaused()
stop()

How to get DisplayMetrics in Activity
DisplayMetrics dm = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(dm);
