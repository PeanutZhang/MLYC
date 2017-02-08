package com.peanut.zyh.mlyc.activitys;

import android.app.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.basepage.BaseActivity;
import com.peanut.zyh.mlyc.fragments.CartFragment;
import com.peanut.zyh.mlyc.fragments.CatagoryFragment;
import com.peanut.zyh.mlyc.fragments.Home_Fragment;
import com.peanut.zyh.mlyc.fragments.JKJFragment;
import com.peanut.zyh.mlyc.fragments.MyFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_radioup)RadioGroup mRadioGroup;
    @BindView(R.id.btn_home)RadioButton mbtn_home;
    @BindView(R.id.btn_9k9)RadioButton mbtn_9k9;
    @BindView(R.id.btn_catagoy)RadioButton mbtn_category;
    @BindView(R.id.btn_my)RadioButton mbtn_my;

    private Home_Fragment mHomeFgt;
    private JKJFragment mJKJFgt;
    private CatagoryFragment mCateFgt;
    private CartFragment mCartFgt;
    private MyFragment mMyFgt;
    private FragmentManager mFgtManger;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFragment();

    }

    private void initFragment() {
        mHomeFgt = new Home_Fragment();
        mJKJFgt = new JKJFragment();
        mCateFgt = new CatagoryFragment();
        mCartFgt = new CartFragment();
        mMyFgt = new MyFragment();
        mFgtManger = getSupportFragmentManager();

        mFgtManger.beginTransaction().replace(R.id.main_container,mHomeFgt).commit();

       mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int position) {

               switch(position){
                   case R.id.btn_home:
                       Log.i("peanut", "onClick: home");
                       mFgtManger.beginTransaction().replace(R.id.main_container,mHomeFgt).commit();

                       break;

                   case R.id.btn_9k9:
                       mFgtManger.beginTransaction().replace(R.id.main_container,mJKJFgt).commit();
                       break;

                   case R.id.btn_catagoy:
                       mFgtManger.beginTransaction().replace(R.id.main_container,mCateFgt).commit();
                       break;

                   case R.id.btn_cart:
                       mFgtManger.beginTransaction().replace(R.id.main_container,mCartFgt).commit();
                       break;

                   case R.id.btn_my:
                       mFgtManger.beginTransaction().replace(R.id.main_container,mMyFgt).commit();
                       break;

                   default:
                       break;

               }

           }
       });




    }


    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }




}
