package com.peanut.zyh.mlyc.activitys;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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



    public static final String Home_FgtTag = "home";
    public static final String JKJ_FgtTag = "jkj";
    public static final String CATE_FgtTag = "cate";
    public static final String CART_FgtTag = "cart";
    public static final String MY_FgtTag = "my";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("peanut", "onCreate: main is gong");
        initFragment();

    }

    private void initFragment() {
        Home_Fragment mHomeFgt = new Home_Fragment();

        FragmentManager mFgtManger = getSupportFragmentManager();

        mFgtManger.beginTransaction().add(R.id.main_container,mHomeFgt,Home_FgtTag).commit();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int position) {
               FragmentTransaction ft = mFgtManger.beginTransaction();
               Fragment homeF = mFgtManger.findFragmentByTag(Home_FgtTag);
               Fragment jkjF = mFgtManger.findFragmentByTag(JKJ_FgtTag);
               Fragment cateF = mFgtManger.findFragmentByTag(CATE_FgtTag);
               Fragment cartF = mFgtManger.findFragmentByTag(CART_FgtTag);
               Fragment my_F = mFgtManger.findFragmentByTag(MY_FgtTag);

               if(homeF!=null){
                   ft.hide(homeF);
               }
               if(jkjF!=null){
                   ft.hide(jkjF);
               }
               if(cateF!=null){
                   ft.hide(cateF);
               }
               if(cartF!=null){
                   ft.hide(cartF);
               }
               if(my_F!=null){
                   ft.hide(my_F);
               }


               switch(position){
                   case R.id.btn_home:

                       if (homeF==null) {

                           ft.add(R.id.main_container,mHomeFgt,Home_FgtTag);
                       } else {
                           ft.show(mHomeFgt);
                       }

                       break;

                   case R.id.btn_9k9:
                       if (jkjF==null) {
                           jkjF = new JKJFragment();
                           ft.add(R.id.main_container,jkjF,JKJ_FgtTag);
                      } else {
                           ft.show(jkjF);
                       }
                       break;

                   case R.id.btn_catagoy:

                       if (cateF==null) {
                           cateF = new CatagoryFragment();
                           ft.add(R.id.main_container,cateF,CATE_FgtTag);

                       } else {
                          ft.show(cateF);
                       }

                       break;

                   case R.id.btn_cart:
                       if (cartF==null) {
                           cartF = new CartFragment();
                           ft.add(R.id.main_container,cartF,CART_FgtTag);
                       } else {
                           ft.show(cartF);
                       }
                       break;

                   case R.id.btn_my:
                       if (my_F==null) {
                           my_F = new MyFragment();
                           ft.add(R.id.main_container,my_F,MY_FgtTag);
                       } else {
                           ft.show(my_F);
                       }
                       break;

                   default:
                       break;

               }

                 ft.commit();
           }


       });


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            RadioButton mTab = (RadioButton) mRadioGroup.getChildAt(i);
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (!mTab.isChecked()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }




}
