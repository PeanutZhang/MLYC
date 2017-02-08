package com.peanut.zyh.mlyc.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;
import java.util.Set;

/**
 * Created by Peanut Zhang on 2017/2/8.
 */

public class Cate_RecyleviewAdapter extends RecyclerView.Adapter {

    private Map<Integer,Object> beanmap;
    private int currentTpe;

    public Cate_RecyleviewAdapter(Map<Integer, Object> beanmap) {
        this.beanmap = beanmap;
    }

    @Override
    public int getItemViewType(int position) {



        return super.getItemViewType(position);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class TopViewHolder extends RecyclerView.ViewHolder{


        public TopViewHolder(View itemView) {
            super(itemView);
        }
    }

    class BottomViewHolder extends RecyclerView.ViewHolder{


        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }


}
