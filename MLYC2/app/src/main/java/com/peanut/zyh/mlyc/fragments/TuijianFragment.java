package com.peanut.zyh.mlyc.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.peanut.zyh.mlyc.GlideImageLoader;
import com.peanut.zyh.mlyc.R;
import com.peanut.zyh.mlyc.activitys.GoodDetailActivity;
import com.peanut.zyh.mlyc.activitys.SplshActivity;
import com.peanut.zyh.mlyc.adapters.TuijanXRViewAdapter;
import com.peanut.zyh.mlyc.common.UrlAPI.TuijianApi;
import com.peanut.zyh.mlyc.common.beans.DaohangBean;
import com.peanut.zyh.mlyc.common.beans.HotnewsBean;
import com.peanut.zyh.mlyc.common.beans.TaoQiangouBean;
import com.peanut.zyh.mlyc.common.beans.TopBannerBean;
import com.peanut.zyh.mlyc.common.beans.TuijianBean;
import com.peanut.zyh.mlyc.utils.RetrofitHelper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuijianFragment extends Fragment {


    private Banner topBanner;
    private ImageView iv_hotTottiao;
    private TextView tv_topTitle;
    private TextView tv_topSubTitle1;
    private TextView tv_topSubTitle2;
    private ImageView iv_teMai;
    private ImageView iv_mianFei;
    private ImageView iv_9K9;
    private ImageView iv_youhuiquan;
    private ImageView iv_20;
    private ImageView iv_taolefttop;
    private ImageView iv_taoleftbottom;
    private ImageView iv_taoright1;
    private ImageView iv_taoright2;
    private ImageView iv_taoright3;


    public TuijianFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.home_tuijianRecview)
    XRecyclerView mXRecyclerView;


    private List<TuijianBean.DataBean.ObjectsBean> mdatas = new ArrayList<>();
    private ArrayList<String> mimages;
    private HotnewsBean hotnews;
    private ArrayList<HotnewsBean.DataBean.ItemsBean> hotNewsTitles;
    private ArrayList<DaohangBean.DataBean> mdaohangDatas;
    List<TaoQiangouBean.DataBean> mtaoQGbean;


    private TuijanXRViewAdapter madapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuijian, container, false);
        ButterKnife.bind(this, view);

        initData();
        initView();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void initData() {
        mimages = new ArrayList<String>();
        hotnews = new HotnewsBean();
        hotNewsTitles = new ArrayList<>();
        mdaohangDatas = new ArrayList<>();
        List<TaoQiangouBean.DataBean> mtaoQGbean = new ArrayList<>();
        mRequestDatas();

        madapter = new TuijanXRViewAdapter(getContext(), mdatas);
    }

    private void initView() {

        //添加头布局
        View head = LayoutInflater.from(getContext()).inflate(R.layout.mainheadlayout, null);
        mXRecyclerView.addHeaderView(head);

        initHeadChildview(head);


        GridLayoutManager mGridManger = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        mXRecyclerView.setLayoutManager(mGridManger);
        mXRecyclerView.setAdapter(madapter);
        madapter.setOnItemClicklister(new TuijanXRViewAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "点击了"+ position, Toast.LENGTH_SHORT).show();
                String url = mdatas.get(position-2).getGmall_product().getMobile_cps_url();

                Intent intent = new Intent(getActivity(), GoodDetailActivity.class);
                intent.putExtra("good_url",url);
                startActivity(intent);
            }
        });
    }

    private void initHeadChildview(View head) {
        topBanner = (Banner) head.findViewById(R.id.top_banner);
        iv_hotTottiao = (ImageView) head.findViewById(R.id.iv_hottoutiao);
        tv_topTitle = (TextView) head.findViewById(R.id.home_tv_hotTitle);
        tv_topSubTitle1 = (TextView) head.findViewById(R.id.home_tv_hotsubTitle);
        tv_topSubTitle2 = (TextView) head.findViewById(R.id.home_tv_hotsubtitle2);
        iv_taolefttop = (ImageView) head.findViewById(R.id.top_left_top);
        iv_taoleftbottom = (ImageView) head.findViewById(R.id.top_left_bottom);
        iv_taoright1 = (ImageView) head.findViewById(R.id.top_right_top);
        iv_taoright2 = (ImageView) head.findViewById(R.id.top_right_bottom_left);
        iv_taoright3 = (ImageView) head.findViewById(R.id.top_right_bottom_right);
        iv_teMai = (ImageView) head.findViewById(R.id.home_iv_daysel);
        iv_mianFei = (ImageView) head.findViewById(R.id.home_iv_freeget);
        iv_9K9 = (ImageView) head.findViewById(R.id.home_iv_jkj);
        iv_youhuiquan = (ImageView) head.findViewById(R.id.home_iv_youhui);
        iv_20 = (ImageView) head.findViewById(R.id.home_iv_t20);

    }

    private void setBanner() {

        topBanner.setImages(mimages)//
                .setIndicatorGravity(BannerConfig.CENTER)//
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)//
                .setImageLoader(new GlideImageLoader())//
                .isAutoPlay(true)//
                .start();

       topBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               Log.i("peanut", "--------->: "+ position);

               if (position!= 1&& hotNewsTitles.size()>(position-2)) {

                   HotnewsBean.DataBean.ItemsBean itemsBean = hotNewsTitles.get(position-2);
                   tv_topTitle.setText(itemsBean.getTitle());
                   tv_topSubTitle1.setText(itemsBean.getSub_tag());
                   tv_topSubTitle2.setText(itemsBean.getSub_title());
               }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }


    private void mRequestDatas() {

        Retrofit retrofit = RetrofitHelper.initRetrofit();

        TuijianApi tuijianApi = retrofit.create(TuijianApi.class);
       //精品推荐列表
        Call<TuijianBean> call = tuijianApi.getTuijianDatas("30");
        call.enqueue(new Callback<TuijianBean>() {
            @Override
            public void onResponse(Call<TuijianBean> call, Response<TuijianBean> response) {
                TuijianBean bean = response.body();
                mdatas.addAll(bean.getData().getObjects());
                madapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<TuijianBean> call, Throwable t) {
                Log.i("peanut", "onFailure: is going");
            }
        });

        //banner 图片
        Call<TopBannerBean> bannerCall = tuijianApi.getBannerBean();
        bannerCall.enqueue(new Callback<TopBannerBean>() {
            @Override
            public void onResponse(Call<TopBannerBean> call, Response<TopBannerBean> response) {
                List<TopBannerBean.DataBean.ItemsBean> bannerUrls = response.body().getData().getItems();

                ArrayList<String> imags = new ArrayList<>();
                for (TopBannerBean.DataBean.ItemsBean items : bannerUrls
                        ) {
                    imags.add(items.getPic_url());

                }

                mimages.clear();
                mimages.addAll(imags);
                setBanner();

            }

            @Override
            public void onFailure(Call<TopBannerBean> call, Throwable t) {

            }
        });

        //热点新闻
        Call<HotnewsBean> hotnewsCall = tuijianApi.getHotnewsDatas();
        hotnewsCall.enqueue(new Callback<HotnewsBean>() {
            @Override
            public void onResponse(Call<HotnewsBean> call, Response<HotnewsBean> response) {
                hotnews = response.body();
                Glide.with(getContext()).load(hotnews.getData().getPic_url()).into(iv_hotTottiao);
                hotNewsTitles.clear();
                hotNewsTitles.addAll(hotnews.getData().getItems());
            }

            @Override
            public void onFailure(Call<HotnewsBean> call, Throwable t) {

            }
        });
       //分类导航
        Call<DaohangBean> daohanCall = tuijianApi.getDaohanDatas();
        daohanCall.enqueue(new Callback<DaohangBean>() {
            @Override
            public void onResponse(Call<DaohangBean> call, Response<DaohangBean> response) {
                List<DaohangBean.DataBean> data = response.body().getData();
                mdaohangDatas.addAll(data);
                Glide.with(getContext()).load(data.get(0).getPic_url()).into(iv_teMai);
                Glide.with(getContext()).load(data.get(1).getPic_url()).into(iv_mianFei);
                Glide.with(getContext()).load(data.get(2).getPic_url()).into(iv_9K9);
                Glide.with(getContext()).load(data.get(3).getPic_url()).into(iv_youhuiquan);
                Glide.with(getContext()).load(data.get(4).getPic_url()).into(iv_20);




            }

            @Override
            public void onFailure(Call<DaohangBean> call, Throwable t) {

            }
        });

        Call<TaoQiangouBean> taoQGCall = tuijianApi.getTaoQGBean();
        taoQGCall.enqueue(new Callback<TaoQiangouBean>() {
            @Override
            public void onResponse(Call<TaoQiangouBean> call, Response<TaoQiangouBean> response) {
                 mtaoQGbean = response.body().getData();
                Glide.with(getContext()).load(mtaoQGbean.get(0).getContent_data().getTqg_left_part().getTop_pic_url()).into(iv_taolefttop);
                Glide.with(getContext()).load(mtaoQGbean.get(0).getContent_data().getTqg_left_part().getItems().get(0).getPic_url()).into(iv_taoleftbottom);
                Glide.with(getContext()).load(mtaoQGbean.get(0).getContent_data().getTqg_right_part().getRight_bottom_part().get(0).getPic_url()).into(iv_taoright1);
                Glide.with(getContext()).load(mtaoQGbean.get(0).getContent_data().getTqg_right_part().getRight_bottom_part().get(0).getPic_url()).into(iv_taoright2);
                Glide.with(getContext()).load(mtaoQGbean.get(0).getContent_data().getTqg_right_part().getRight_bottom_part().get(1).getPic_url()).into(iv_taoright3);

            }

            @Override
            public void onFailure(Call<TaoQiangouBean> call, Throwable t) {

            }
        });
    }


}
