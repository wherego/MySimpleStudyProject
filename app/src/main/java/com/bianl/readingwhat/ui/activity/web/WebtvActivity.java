package com.bianl.readingwhat.ui.activity.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.BaseActivity;

import butterknife.BindView;

public class WebtvActivity extends BaseActivity {

    private final static String KEY_URL = "WebtvActivity";

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_webtv;
    }

    @Override
    protected void initView() {
        String url = getIntent().getStringExtra(KEY_URL);
        webViewInit(url);
    }

    @BindView(R.id.webtv_web)
    WebView webTvWeb;

    @SuppressLint("SetJavaScriptEnabled")
    private void webViewInit(String url) {
        webTvWeb.loadUrl(url);
        webTvWeb.setWebViewClient(new WebViewClient());
        webTvWeb.setWebChromeClient(new WebChromeClient());

        WebSettings settings = webTvWeb.getSettings();
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
//        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webTvWeb != null) {
            webTvWeb.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webTvWeb != null) {
            webTvWeb.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webTvWeb != null) {
            webTvWeb.destroy();
        }
    }

    public static void startWebTvActivity(Activity activity, String url) {
        Intent intent = new Intent(activity, WebtvActivity.class);
        intent.putExtra(KEY_URL, url);
        activity.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (webTvWeb.canGoBack() && webTvWeb != null) {
            webTvWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
