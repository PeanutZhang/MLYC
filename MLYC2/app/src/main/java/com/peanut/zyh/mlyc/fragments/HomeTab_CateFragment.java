package com.peanut.zyh.mlyc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.peanut.zyh.mlyc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTab_CateFragment extends Fragment {


    public HomeTab_CateFragment() {
        // Required empty public constructor
    }
     private Unbinder unbinder;
     @BindView(R.id.cate_recleview)RecyclerView mrecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_tab__cate, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        LinearLayoutManager LLManger = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mrecyclerView.setLayoutManager(LLManger);
        mrecyclerView.setLayoutManager(null);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
     unbinder.unbind();

    }
}
