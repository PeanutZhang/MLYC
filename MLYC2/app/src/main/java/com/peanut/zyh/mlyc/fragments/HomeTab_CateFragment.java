package com.peanut.zyh.mlyc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peanut.zyh.mlyc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTab_CateFragment extends Fragment {


    public HomeTab_CateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tab__cate, container, false);
    }

}
