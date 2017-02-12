package com.peanut.zyh.mlyc.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.basepage.BaseActivity;
import com.peanut.zyh.mlyc.common.UrlAPI.TuijianApi;
import com.peanut.zyh.mlyc.common.beans.TuijianBean;
import com.peanut.zyh.mlyc.utils.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplshActivity extends BaseActivity {
    private Handler mhandler=null;
    private boolean isFirst= true;

    private List<TuijianBean.DataBean.ObjectsBean> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        init();



    }

    private void init() {
        checkFirstin();

        mhandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Intent it= null;
                if(isFirst){

                    it = new Intent(SplshActivity.this,GuideActivity.class);

                }else {
                    it = new Intent(SplshActivity.this,MainActivity.class);

                }

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






    private void checkFirstin() {

        SharedPreferences sp = getSharedPreferences("flag", Context.MODE_PRIVATE);
        isFirst = sp.getBoolean("isfirst",true);


    }

    @Override
    public int getLayout() {
        return R.layout.activity_splsh;
    }


}
