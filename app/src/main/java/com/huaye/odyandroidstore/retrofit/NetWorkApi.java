package com.huaye.odyandroidstore.retrofit;

import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface NetWorkApi {

    @GET("https://s.m.taobao.com/search?event_submit_do_new_search_auction=1&_input_charset=utf-8&topSearch=1&atype=b&searchfrom=1&action=home%3Aredirect_app_action&from=1&sst=1&n=20&buying=buyitnow&m=api4h5&abtest=13&wlsort=13")
    Observable<TaoBaoProductBean> getProductList(@Query("q") String q, @Query("page") int page);
}