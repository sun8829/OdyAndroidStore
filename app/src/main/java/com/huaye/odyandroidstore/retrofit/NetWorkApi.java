package com.huaye.odyandroidstore.retrofit;

import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface NetWorkApi {
    //https://s.m.taobao.com/search?event_submit_do_new_search_auction=1&_input_charset=utf-8&topSearch=1&atype=b&searchfrom=1&action=home%3Aredirect_app_action&from=1&sst=1&n=20&buying=buyitnow&m=api4h5&abtest=11&wlsort=11&style=list&closeModues=nav%2Cselecthot%2Conesearch&sort=_sale&page=1
    @GET("https://s.m.taobao.com/search?event_submit_do_new_search_auction=1&_input_charset=utf-8&topSearch=1&atype=b&searchfrom=1&action=home%3Aredirect_app_action&from=1&sst=1&n=20&buying=buyitnow&m=api4h5&abtest=13&wlsort=13")
    Observable<TaoBaoProductBean> getProductList(@Query("q") String q, @Query("page") int page);

    @GET("https://s.m.taobao.com/search?event_submit_do_new_search_auction=1&_input_charset=utf-8&topSearch=1&atype=b&searchfrom=1&action=home%3Aredirect_app_action&from=1&sst=1&n=20&buying=buyitnow&m=api4h5&abtest=13&wlsort=13")
    Observable<TaoBaoProductBean> getProductList(@QueryMap Map<String, String> params);
}