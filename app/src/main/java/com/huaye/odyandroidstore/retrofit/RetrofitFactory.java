package com.huaye.odyandroidstore.retrofit;

import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import rx.Observable;

/**
 * Created by Administrator on 2016/11/30.
 */

public class RetrofitFactory {
    protected static final Object monitor = new Object();
    static NetWorkApi sNetWorkApi = null;


    public static NetWorkApi getNetWorkApi() {
        synchronized (monitor) {
            if (sNetWorkApi == null) {
                sNetWorkApi = new RetrofitHelper().getCategoryService();
            }
            return sNetWorkApi;
        }
    }

    /**
     * 获取分类页数据
     *
     * @param q
     * @return
     */
    public static Observable<TaoBaoProductBean> getProductList(String q, int page) {
        return getNetWorkApi().getProductList(q, page);
    }
}
