package com.peanut.zyh.mlyc.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.common.Cate_TopBean;
import com.peanut.zyh.mlyc.common.MLYCAPI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTab_CateFragment extends Fragment {


    public HomeTab_CateFragment() {
        // Required empty public constructor
    }
     private Unbinder unbinder;
    //@BindView(R.id.pull_refresh_list) PullToRefreshListView mPullToReList;
    @BindView(R.id.main_cate_recyclerview)
    XRecyclerView mXRecyclerview;
    private ArrayList<Cate_TopBean.DataBean.CategoryListBean> topbean_data = new ArrayList<>();

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
        GridLayoutManager mgridManger = new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);
        View header =   LayoutInflater.from(getContext()).inflate(R.layout.headview, null,false);

         mXRecyclerview.addHeaderView(header);
         mXRecyclerview.setLayoutManager(mgridManger);
         mXRecyclerview.setAdapter(new mytopAdatper());

        RecyclerView headerRecyleview = (RecyclerView) header.findViewById(R.id.header_reclyeview);


        GridLayoutManager gridManger = new GridLayoutManager(getContext(),5,LinearLayoutManager.VERTICAL,false);

        headerRecyleview.setLayoutManager(gridManger);
//        headerRecyleview.addItemDecoration(new RecyclerView.ItemDecoration() {
//        });
        headerRecyleview.setAdapter(new mytopAdatper());



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

    class mytopAdatper extends RecyclerView.Adapter<mytopAdatper.myviewholder>{


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
                    .into(holder.mimageView);


        }

        @Override
        public int getItemCount() {
            return topbean_data.size();
        }

        class  myviewholder extends RecyclerView.ViewHolder{

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

      requsetJson();
    }

    private void requsetJson() {
        Log.i("peanut", "requsetJson: is going");
        Retrofit retrofit = new Retrofit.Builder()//
                                 .baseUrl(MLYCAPI.hostUrl)//
                                  .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//
                                   .addConverterFactory(GsonConverterFactory.create())//
                                    .build();


        MLYCAPI mlycapi = retrofit.create(MLYCAPI.class);
        Observable<Cate_TopBean> mobsevable = mlycapi.getCateBean("digitaloffice");

        mobsevable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Action1<Cate_TopBean>() {
                    @Override
                    public void call(Cate_TopBean cate_topBean) {
                       topbean_data.addAll(cate_topBean.getData().getCategory_list());

                        Log.i("peanut", "------->: "+topbean_data.size());
                    }
                });


    }
}
