package com.huaye.odyandroidstore.retrofit;

import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import java.util.HashMap;
import java.util.Map;

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
    public static Observable<TaoBaoProductBean> getProductList(String q, String page) {
        Map<String, String> params = new HashMap<>();
        params.put("q", q);
        params.put("page", page);
        return getNetWorkApi().getProductList(params);
    }

    /**
     * 获取分类页数据
     *
     * @return
     */
    public static Observable<TaoBaoProductBean> getProductList(Map<String, String> params) {
//        Map<String, String> params = new HashMap<>();
//        params.put("q", q);
//        params.put("page", page);
//        params.put("sort", sort);
        return getNetWorkApi().getProductList(params);
    }
}
