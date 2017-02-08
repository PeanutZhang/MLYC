package com.peanut.zyh.mlyc.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peanut.zyh.mlyc.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {


    private ArrayList<String> tab_title;
    private ArrayList<Fragment> fragments;

    public Home_Fragment() {

    }

    @BindView(R.id.home_topTabBar)TabLayout mToptabBar;
    @BindView(R.id.home_viewpager)ViewPager mviewPager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null, false);
        munbinder = ButterKnife.bind(this, view);

       initView();

        return view;

    }

    private void initView() {
       mToptabBar.setTabMode(TabLayout.MODE_SCROLLABLE);


        mviewPager.setAdapter(new MyviepageAdapter(getFragmentManager()));

        mToptabBar.setupWithViewPager(mviewPager);

        for (int i = 0; i <tab_title.size(); i++) {
            mToptabBar.getTabAt(i).setText(tab_title.get(i));
        }

       mToptabBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               //解决点击tab 切换 页面闪烁问题
               mviewPager.setCurrentItem(tab.getPosition(),false);
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }

    private void initData() {
        tab_title = new ArrayList<>();
        tab_title.add("推荐");
        tab_title.add("男装");
        tab_title.add("数码");
        tab_title.add("车配");
        tab_title.add("鞋包");
        tab_title.add("保健");
        tab_title.add("推荐");
        tab_title.add("女装");
        tab_title.add("中老年");
        tab_title.add("童装");
        tab_title.add("美装");
        tab_title.add("家居");
        tab_title.add("图书");
        tab_title.add("水果");

        fragments = new ArrayList<>();
        fragments.add(new TuijianFragment());
        for (int i = 0; i <tab_title.size() ; i++) {
            fragments.add(new HomeTab_CateFragment());
        }


    }

 class MyviepageAdapter extends FragmentStatePagerAdapter{

     public MyviepageAdapter(FragmentManager fm) {
         super(fm);
     }

     @Override
     public Fragment getItem(int position) {
         return fragments.get(position);
     }

     @Override
     public int getCount() {
         return fragments.size()-1;
     }
 }





    private Unbinder munbinder ;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        munbinder.unbind();


    }
}
