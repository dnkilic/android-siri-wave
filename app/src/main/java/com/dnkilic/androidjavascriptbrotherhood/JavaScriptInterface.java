package com.dnkilic.androidjavascriptbrotherhood;

import android.content.Context;
import android.content.Intent;

/**
 * Created by dogan.kilic on 19.07.2016.
 */
public class JavaScriptInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    JavaScriptInterface(Context c) {
        mContext = c;
    }

    public void changeActivity()
    {
        /*Intent i = new Intent(JavascriptInterfaceActivity.this, nextActivity.class);
        startActivity(i);
        finish();*/
    }
}