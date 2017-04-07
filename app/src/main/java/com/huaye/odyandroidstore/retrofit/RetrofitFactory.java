package com.huaye.odyandroidstore.retrofit;

import com.huaye.odyandroidstore.base.Ad;
import com.huaye.odyandroidstore.imitate.lyf.home.AdBean;
import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

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

    /**
     * 获取广告数据
     */
    public static Observable<List<Ad>> getAd(String adCode, String pageCode) {
        Observable.create(new Observable.OnSubscribe<AdBean>() {
            @Override
            public void call(Subscriber<? super AdBean> subscriber) {

            }
        });
        Map<String, String> params = new HashMap<>();
        params.put("adCode", adCode);
        params.put("pageCode", pageCode);
        return getNetWorkApi().getAd(params)
                .filter(new Func1<AdBean, Boolean>() {
                    @Override
                    public Boolean call(AdBean adBean) {
                        return adBean != null && adBean.ad_banner != null;
                    }
                })
                .map(new Func1<AdBean, List<Ad>>() {
                    @Override
                    public List<Ad> call(AdBean adBean) {
                        return adBean.ad_banner;
                    }
                });
    }
}
