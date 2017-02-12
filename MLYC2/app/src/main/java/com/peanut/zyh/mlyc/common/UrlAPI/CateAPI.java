package com.peanut.zyh.mlyc.common.UrlAPI;

import com.peanut.zyh.mlyc.common.beans.Cate_BottomBean;
import com.peanut.zyh.mlyc.common.beans.Cate_TopBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Peanut Zhang on 2017/2/8.
 */

public interface CateAPI {
    /**
     * host地址
     */
    String hostUrl = "http://api.yuike.com/gmall/api/1.0/";

    /**
     * 分类
     * @param type
     * @return
     */
    @GET("allbuy/category_list.php?mid=457465&type=men&yk_pid=3&yk_appid=1&yk_cc=yuikemall&yk_cvc=317&cursor=0&count=40")
    Call<Cate_TopBean> getCateBean(@Query("type")String type);

    @GET("allbuy/list.php?mid=457465&type=digitaloffice&category_ids=0&channel_id=1468223404&sort=default&get_new=true&is_section=true&yk_pid=3&yk_appid=1&yk_cc=yuikemall&yk_cvc=317&cursor=0&count=40")
    Call<Cate_BottomBean> getBottombean(@Query("type")String type);
}
