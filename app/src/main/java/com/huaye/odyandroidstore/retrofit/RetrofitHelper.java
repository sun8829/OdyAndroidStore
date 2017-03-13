package com.huaye.odyandroidstore.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/30.
 */

public class RetrofitHelper {
    public static final String BASE_URL = "https://s.m.taobao.com";
    private static final int DEFAULT_TIMEOUT = 15;
    NetWorkApi netWorkApi;
    private Retrofit retrofit;

    public RetrofitHelper() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        Retrofit.Builder b = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL);

        retrofit = b.build();
    }

    public NetWorkApi getCategoryService() {
        return retrofit.create(NetWorkApi.class);
    }
}
