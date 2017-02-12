package com.peanut.zyh.mlyc.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.peanut.zyh.mlyc.GlideImageLoader;
import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.basepage.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {
   @BindView(R.id.guide_banner)
     Banner mbaner;
    private List<Integer> img_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       initData();
        initView();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_guide;
    }

    private void initView() {

        mbaner.setImages(img_list)//
              .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)//
              .setImageLoader(new GlideImageLoader())//
              .isAutoPlay(true)//
              .setIndicatorGravity(BannerConfig.CENTER)//
              .start();


       mbaner.setOnBannerClickListener(new OnBannerClickListener() {
           @Override
           public void OnBannerClick(int position) {
                                                          // flag 生成的文件名
               SharedPreferences sp = getSharedPreferences("flag", Context.MODE_PRIVATE);
               sp.edit().putBoolean("isfirst",false).commit();

                   Intent it = new Intent(GuideActivity.this,MainActivity.class);
                   startActivity(it);
               GuideActivity.this.finish();

           }
       });
    }

    private void initData() {

        img_list = new ArrayList<>();
        img_list.add(R.drawable.yuike_path_bg1);
        img_list.add(R.drawable.yuike_path_bg2);
        img_list.add(R.drawable.yuike_path_bg3);
        img_list.add(R.drawable.yuike_path_bg4);

    }
}
