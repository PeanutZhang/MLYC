package com.peanut.zyh.mlyc.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.activitys.GoodDetailActivity;
import com.peanut.zyh.mlyc.adapters.TuijanXRViewAdapter;
import com.peanut.zyh.mlyc.common.beans.Cate_BottomBean;
import com.peanut.zyh.mlyc.common.beans.Cate_TopBean;
import com.peanut.zyh.mlyc.common.UrlAPI.CateAPI;
import com.peanut.zyh.mlyc.utils.RetrofitHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTab_CateFragment extends Fragment {


    private HomeTab_CateFragment.mybottomAdapter mybottomAdapter;
    private HomeTab_CateFragment.mytopAdatper mytopAdatper;

    public HomeTab_CateFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;
    //@BindView(R.id.pull_refresh_list) PullToRefreshListView mPullToReList;
    @BindView(R.id.main_cate_recyclerview)
    XRecyclerView mXRecyclerview;

    //Mode_________________
    private ArrayList<Cate_TopBean.DataBean.CategoryListBean> topbean_data = new ArrayList<>();
    private ArrayList<Cate_BottomBean.DataBean.ObjectsBean> bottombean_data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_tab__cate, container, false);
        unbinder = ButterKnife.bind(this, view);

        // initView();
        initView2();

        return view;
    }

    private void initView2() {
        GridLayoutManager mgridManger = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
       // View header = LayoutInflater.from(getContext()).inflate(R.layout.headview, null, false);
      View header=   View.inflate(getContext(),R.layout.headview,null);
        mXRecyclerview.addHeaderView(header);
        mXRecyclerview.setLayoutManager(mgridManger);


        mybottomAdapter = new mybottomAdapter();
        mXRecyclerview.setAdapter(mybottomAdapter);

        RecyclerView headerRecyleview = (RecyclerView) header.findViewById(R.id.header_reclyeview);


        GridLayoutManager gridManger = new GridLayoutManager(getContext(), 5, LinearLayoutManager.VERTICAL, false);

        headerRecyleview.setLayoutManager(gridManger);

        mytopAdatper = new mytopAdatper();
        headerRecyleview.setAdapter(mytopAdatper);


    }

//    private void initView() {
//
//        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
//       // View headerView = getLayoutInflater(null).inflate(R.layout.headview, mPullToReList, false);
//      //  headerView.setLayoutParams(layoutParams);
//        ListView lv = mPullToReList.getRefreshableView();
//        lv.addHeaderView(headerView);
//
//        ArrayList<String> data = new ArrayList<>();
//        data.add("测试");
//        data.add("测试");
//        data.add("测试");
//        data.add("测试");
//
//        RecyclerView headerRecyleview = (RecyclerView) headerView.findViewById(R.id.header_reclyeview);
//
//        ArrayAdapter ada = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, data);
//        mPullToReList.setAdapter(ada);
//
//        GridLayoutManager gridManger = new GridLayoutManager(getContext(),5,LinearLayoutManager.VERTICAL,false);
//
//        headerRecyleview.setLayoutManager(gridManger);
////        headerRecyleview.addItemDecoration(new RecyclerView.ItemDecoration() {
////        });
//        headerRecyleview.setAdapter(new mytopAdatper());
//
//    }

    class mybottomAdapter extends RecyclerView.Adapter<mybottomAdapter.Myviewholder> {


        protected View rootView;
        protected ImageView ivGood;
        protected TextView tvGoodtitle;
        protected TextView tvSelprice;
        protected TextView tvSelvloume;

        @Override
        public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = View.inflate(getContext(), R.layout.item_mainlayout, null);
            Myviewholder holder = new Myviewholder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(Myviewholder holder, int position) {
            if (bottombean_data.get(position).getGmall_product() != null) {


            holder.tv_goodtitle.setText(bottombean_data.get(position).getGmall_product().getTitle());
            holder.tv_goodprice.setText(bottombean_data.get(position).getGmall_product().getSelling_price());
            holder.tv_selvloum.setText(bottombean_data.get(position).getGmall_product().getSales_volume());
            Glide.with(getContext())
                    .load(bottombean_data.get(position).getGmall_product().getPic_url())//
                    .placeholder(R.drawable.yuike_cartoon_pitiful)//
                     .error(R.drawable.error)
                    .into(holder.iv_good);//

            }
        }

        @Override
        public int getItemCount() {
            return bottombean_data.size();
        }



        class Myviewholder extends RecyclerView.ViewHolder {

            @BindView(R.id.iv_good) ImageView iv_good;
            @BindView(R.id.tv_goodtitle) TextView tv_goodtitle;
            @BindView(R.id.tv_selprice) TextView tv_goodprice;
            @BindView(R.id.tv_selvloume) TextView tv_selvloum;

            public Myviewholder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), GoodDetailActivity.class);
                       String good_url =  bottombean_data.get(getAdapterPosition()-2).getGmall_product().getMobile_cps_url();
                       intent.putExtra("good_url",good_url);
                        startActivity(intent);

                    }
                });

            }


        }


    }

    class mytopAdatper extends RecyclerView.Adapter<mytopAdatper.myviewholder> {


        @Override
        public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = View.inflate(parent.getContext(), R.layout.item_headview, null);
            myviewholder myviewholder = new myviewholder(view);
            return myviewholder;
        }

        @Override
        public void onBindViewHolder(myviewholder holder, int position) {


            holder.title.setText(topbean_data.get(position).getTitle());
            Glide.with(getContext())
                    .load(topbean_data.get(position).getPic_url())
                    .placeholder(R.drawable.yuike_cartoon_pitiful)//
                    .error(R.drawable.error)//
                    .into(holder.mimageView);


        }

        @Override
        public int getItemCount() {
            return topbean_data.size();//==0?6:topbean_data.size();
        }

        class myviewholder extends RecyclerView.ViewHolder {

            ImageView mimageView;
            TextView title;

            public myviewholder(View itemView) {
                super(itemView);
                mimageView = (ImageView) itemView.findViewById(R.id.iv_header_item);
                title = (TextView) itemView.findViewById(R.id.tv_header_item);
            }


        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            requsetJson();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void requsetJson() {


        Retrofit retrofit = RetrofitHelper.initRetrofit();
        CateAPI mlycapi = retrofit.create(CateAPI.class);
//使用rxjava 返回 无网络时闪退
//            Observable<Cate_TopBean> mobsevable = mlycapi.getCateBean("digitaloffice");

//            mobsevable.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//
//                    .subscribe(new Action1<Cate_TopBean>() {
//                        @Override
//                        public void call(Cate_TopBean cate_topBean) {
//                            if (cate_topBean != null) {
//                                topbean_data.clear();
//                                topbean_data.addAll(cate_topBean.getData().getCategory_list());
//
//                                Log.i("peanut", "------->: " + topbean_data.size());
//                            }
//
//                        }
//                    });
        retrofit2.Call<Cate_TopBean> mcall = mlycapi.getCateBean("digitaloffice");
        mcall.enqueue(new Callback<Cate_TopBean>() {
            @Override
            public void onResponse(retrofit2.Call<Cate_TopBean> call, Response<Cate_TopBean> response) {
                Cate_TopBean bean = response.body();
                topbean_data.clear();
                topbean_data.addAll(bean.getData().getCategory_list());
                mytopAdatper.notifyDataSetChanged();

            }

            @Override
            public void onFailure(retrofit2.Call<Cate_TopBean> call, Throwable t) {

            }
        });

        retrofit2.Call<Cate_BottomBean> mbotcall = mlycapi.getBottombean("digitaloffice");
        mbotcall.enqueue(new Callback<Cate_BottomBean>() {
            @Override
            public void onResponse(retrofit2.Call<Cate_BottomBean> call, Response<Cate_BottomBean> response) {
                bottombean_data.clear();
                bottombean_data.addAll(response.body().getData().getObjects());
               mybottomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(retrofit2.Call<Cate_BottomBean> call, Throwable t) {

            }
        });

    }
}
