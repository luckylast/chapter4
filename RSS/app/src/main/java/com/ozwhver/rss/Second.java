package com.ozwhver.rss;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Sairamkrishna on 4/6/2015.
 */
public class Second extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        WebView w1=(WebView)findViewById(R.id.webView);
        w1.loadUrl("http://tutorialspoint.com/android/sampleXML.xml");
    }
}
