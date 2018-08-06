package com.brsg.readpdfdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewTestActivity extends AppCompatActivity {
    private WebView mWebView;
    private String testPath = "file:///android_asset/test.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);
        mWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
        Log.e("open", "testPath");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open:
                //本地-自定义
                //mWebView.loadUrl("file:///android_asset/index.html?" + testPath);
                //本地-pdf.js原生
                mWebView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=" + testPath);
                //pdf.js在线
                //mWebView.loadUrl("http://mozilla.github.io/pdf.js/web/viewer.html?file=" + testPath);
                //google在线
                // mWebView.loadUrl("http://docs.google.com/gviewembedded=true&url=" + testPath);
                Log.e("open", "testPath");
                break;
        }
    }

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, WebViewTestActivity.class));
    }
}
