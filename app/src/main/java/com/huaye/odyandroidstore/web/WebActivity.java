package com.huaye.odyandroidstore.web;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

public class WebActivity extends BaseActivity {
    private WebView wv;
    private String url;
    private WebSettings ws;

    @Override
    protected void init() {
        super.init();
        url = getIntent().getStringExtra("extra");
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        wv = (WebView) findViewById(R.id.wv);
        ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        wv.loadUrl(url);
    }
}
