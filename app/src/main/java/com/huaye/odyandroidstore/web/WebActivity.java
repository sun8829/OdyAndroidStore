package com.huaye.odyandroidstore.web;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.utils.StringUtils;

public class WebActivity extends BaseActivity {
    private WebView wv;
    private String url;
    private WebSettings ws;
    private TextView titleTxt;

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
        titleTxt = (TextView) findViewById(R.id.title);
        ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }

        });

        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (!StringUtils.isEmpty(title)) {
                    titleTxt.setText(title);
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        titleTxt.setText(url);
        wv.loadUrl(url);
    }
}
