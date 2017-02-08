package com.peanut.zyh.mlyc.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.basepage.BaseActivity;

public class SplshActivity extends BaseActivity {
    private Handler mhandler=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);


        mhandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Intent it = new Intent(SplshActivity.this,GuideActivity.class);
                startActivity(it);
                SplshActivity.this.finish();
            }
        };



        new Thread(new Runnable() {
            @Override
            public void run() {
                mhandler.sendEmptyMessageDelayed(5,2000);
            }
        }).start();

    }

    @Override
    public int getLayout() {
        return R.layout.activity_splsh;
    }
}
