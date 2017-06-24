package com.turtledev.easybrowser;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        WebView webView=(WebView)findViewById(R.id.webView);

        //Intent intent=getIntent();



        Uri data=getIntent().getData();
        webView.loadUrl(data.toString());
    }
}
