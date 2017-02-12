package com.peanut.zyh.mlyc.common.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Peanut Zhang on 2017/2/8.
 */

public class Cate_TopBean implements Parcelable {

    /**
     * msg : ok
     * ret : 0
     * data : {"category_list":[{"cids":"0","crowd_type":"2","id":"1464784069","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/6d42ca3079ef809bf79fdf0b5f0f365c.jpg","title":"全部"},{"cids":"22159","crowd_type":"2","id":"1470040578","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/13c2248560f9d63514697be0a2af2f00.jpg","title":"冬季新品"},{"cids":"22178","crowd_type":"2","id":"1476002446","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/e079e57da98bff53cc8eed595d8b7ad8.jpg","title":"羽绒服"},{"cids":"22157","crowd_type":"2","id":"1470040513","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/11d1df285611063a9ec2e452eb7367e2.jpg","title":"外套"},{"cids":"22177","crowd_type":"2","id":"1476002471","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/911936d6950c430d89e66338a9453233.jpg","title":"羊毛衫"},{"cids":"22176","crowd_type":"2","id":"1476002485","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/d48f30522eca5def723ed0d569ad4a3c.jpg","title":"针织衫"},{"cids":"22156","crowd_type":"2","id":"1470040524","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/06e393faaa60d6f4019e2a6e403ce1ef.jpg","title":"卫衣"},{"cids":"4863","crowd_type":"2","id":"1464784071","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/a78b2eb8bc6944c652d50264d2b77581.jpg","title":"T恤"},{"cids":"4864","crowd_type":"2","id":"1464784073","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/8cc9c2fdb57ed1c1e87766c1f5b30f47.jpg","title":"衬衫"},{"cids":"4867","crowd_type":"2","id":"1464784079","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/b8be16ef9a92fb2f5c44365652fb2bc9.jpg","title":"POLO衫"},{"cids":"4869","crowd_type":"2","id":"1464784083","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/10bbf9d7e408f07d683d557206edb45e.jpg","title":"休闲裤"},{"cids":"4870","crowd_type":"2","id":"1464784085","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/57b1f8e74f34d988bbe21e24369ab09e.jpg","title":"牛仔裤"},{"cids":"4872","crowd_type":"2","id":"1464784089","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/e482137ba2fe45a4f510f00ca2115926.jpg","title":"运动裤"},{"cids":"4889","crowd_type":"2","id":"1464784087","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/bda6e3faad52c1bc634cbb2740732d95.jpg","title":"内裤"}],"home_show_count":"8","subtitle":"每天10点准时上新","title":"男装"}
     * publish_status : 0
     * publish_time : 1476002571
     */

    private String msg;
    private int ret;
    private DataBean data;
    private int publish_status;
    private String publish_time;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getPublish_status() {
        return publish_status;
    }

    public void setPublish_status(int publish_status) {
        this.publish_status = publish_status;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public static class DataBean implements Parcelable {
        /**
         * category_list : [{"cids":"0","crowd_type":"2","id":"1464784069","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/6d42ca3079ef809bf79fdf0b5f0f365c.jpg","title":"全部"},{"cids":"22159","crowd_type":"2","id":"1470040578","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/13c2248560f9d63514697be0a2af2f00.jpg","title":"冬季新品"},{"cids":"22178","crowd_type":"2","id":"1476002446","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/e079e57da98bff53cc8eed595d8b7ad8.jpg","title":"羽绒服"},{"cids":"22157","crowd_type":"2","id":"1470040513","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/11d1df285611063a9ec2e452eb7367e2.jpg","title":"外套"},{"cids":"22177","crowd_type":"2","id":"1476002471","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/911936d6950c430d89e66338a9453233.jpg","title":"羊毛衫"},{"cids":"22176","crowd_type":"2","id":"1476002485","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/d48f30522eca5def723ed0d569ad4a3c.jpg","title":"针织衫"},{"cids":"22156","crowd_type":"2","id":"1470040524","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/06e393faaa60d6f4019e2a6e403ce1ef.jpg","title":"卫衣"},{"cids":"4863","crowd_type":"2","id":"1464784071","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/a78b2eb8bc6944c652d50264d2b77581.jpg","title":"T恤"},{"cids":"4864","crowd_type":"2","id":"1464784073","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/8cc9c2fdb57ed1c1e87766c1f5b30f47.jpg","title":"衬衫"},{"cids":"4867","crowd_type":"2","id":"1464784079","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/b8be16ef9a92fb2f5c44365652fb2bc9.jpg","title":"POLO衫"},{"cids":"4869","crowd_type":"2","id":"1464784083","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/10bbf9d7e408f07d683d557206edb45e.jpg","title":"休闲裤"},{"cids":"4870","crowd_type":"2","id":"1464784085","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/57b1f8e74f34d988bbe21e24369ab09e.jpg","title":"牛仔裤"},{"cids":"4872","crowd_type":"2","id":"1464784089","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/e482137ba2fe45a4f510f00ca2115926.jpg","title":"运动裤"},{"cids":"4889","crowd_type":"2","id":"1464784087","is_hight_commission_plan":"1","max_coupon_money":0,"min_coupon_money":0,"pic_url":"http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/bda6e3faad52c1bc634cbb2740732d95.jpg","title":"内裤"}]
         * home_show_count : 8
         * subtitle : 每天10点准时上新
         * title : 男装
         */

        private String home_show_count;
        private String subtitle;
        private String title;
        private List<CategoryListBean> category_list;

        protected DataBean(Parcel in) {
            home_show_count = in.readString();
            subtitle = in.readString();
            title = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getHome_show_count() {
            return home_show_count;
        }

        public void setHome_show_count(String home_show_count) {
            this.home_show_count = home_show_count;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<CategoryListBean> getCategory_list() {
            return category_list;
        }

        public void setCategory_list(List<CategoryListBean> category_list) {
            this.category_list = category_list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(home_show_count);
            parcel.writeString(subtitle);
            parcel.writeString(title);
        }

        public static class CategoryListBean {
            /**
             * cids : 0
             * crowd_type : 2
             * id : 1464784069
             * is_hight_commission_plan : 1
             * max_coupon_money : 0
             * min_coupon_money : 0
             * pic_url : http://gouwu.cdn.yuike.com/data/img/457465/allbuy_category/6d42ca3079ef809bf79fdf0b5f0f365c.jpg
             * title : 全部
             */

            private String cids;
            private String crowd_type;
            private String id;
            private String is_hight_commission_plan;
            private int max_coupon_money;
            private int min_coupon_money;
            private String pic_url;
            private String title;

            public String getCids() {
                return cids;
            }

            public void setCids(String cids) {
                this.cids = cids;
            }

            public String getCrowd_type() {
                return crowd_type;
            }

            public void setCrowd_type(String crowd_type) {
                this.crowd_type = crowd_type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIs_hight_commission_plan() {
                return is_hight_commission_plan;
            }

            public void setIs_hight_commission_plan(String is_hight_commission_plan) {
                this.is_hight_commission_plan = is_hight_commission_plan;
            }

            public int getMax_coupon_money() {
                return max_coupon_money;
            }

            public void setMax_coupon_money(int max_coupon_money) {
                this.max_coupon_money = max_coupon_money;
            }

            public int getMin_coupon_money() {
                return min_coupon_money;
            }

            public void setMin_coupon_money(int min_coupon_money) {
                this.min_coupon_money = min_coupon_money;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.msg);
        dest.writeInt(this.ret);
        dest.writeParcelable(this.data, flags);
        dest.writeInt(this.publish_status);
        dest.writeString(this.publish_time);
    }

    public Cate_TopBean() {
    }

    protected Cate_TopBean(Parcel in) {
        this.msg = in.readString();
        this.ret = in.readInt();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
        this.publish_status = in.readInt();
        this.publish_time = in.readString();
    }

    public static final Parcelable.Creator<Cate_TopBean> CREATOR = new Parcelable.Creator<Cate_TopBean>() {
        @Override
        public Cate_TopBean createFromParcel(Parcel source) {
            return new Cate_TopBean(source);
        }

        @Override
        public Cate_TopBean[] newArray(int size) {
            return new Cate_TopBean[size];
        }
    };
}
