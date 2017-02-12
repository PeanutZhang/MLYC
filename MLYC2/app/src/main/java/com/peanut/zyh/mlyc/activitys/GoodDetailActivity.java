package com.peanut.zyh.mlyc.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.basepage.BaseActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

import static android.R.attr.keycode;

public class GoodDetailActivity extends BaseActivity {

    @BindView(R.id.webView_goodDetail)WebView mWebView;

    String good_Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     initDatas();
     initView();

    }

    private void initDatas() {
        Intent intent = getIntent();
        good_Url = intent.getStringExtra("good_url");
    }

    private void initView() {

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());//设置调用内置浏览器
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

                    if (keycode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {

                        mWebView.goBack();
                        return true;

                    }
                }
                return false;
            }
        });
        if (good_Url != null) {
            mWebView.loadUrl(good_Url);
        }

    }


    @Override
    public int getLayout() {
        return R.layout.activity_good_detail;
    }
}
