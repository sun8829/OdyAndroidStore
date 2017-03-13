package com.huaye.odyandroidstore.imitate.taobao;

import com.huaye.odyandroidstore.retrofit.RetrofitFactory;
import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;
import com.huaye.odyandroidstore.subscribe.ApiSubscriber;
import com.huaye.odyandroidstore.subscribe.SubscriberListener;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Samuel on 2017/3/13.
 */

public class SearchResultPresenter {
    private SearchResultView mView;

    public SearchResultPresenter(SearchResultView view) {
        mView = view;
    }

    public void getProductList(String key, final int page) {
        RetrofitFactory.getProductList(key, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiSubscriber<TaoBaoProductBean>(new SubscriberListener<TaoBaoProductBean>() {
                    @Override
                    public void onNext(TaoBaoProductBean bean) {
                        if (page > 1) {
                            mView.addProduct(bean.listItem);
                        } else {
                            mView.showProduct(bean.listItem);
                        }
                    }
                }));
    }
}
