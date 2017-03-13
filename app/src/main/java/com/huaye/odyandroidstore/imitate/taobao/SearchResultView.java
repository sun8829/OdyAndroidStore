package com.huaye.odyandroidstore.imitate.taobao;

import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import java.util.List;

/**
 * Created by Samuel on 2017/3/13.
 */

public interface SearchResultView {
    void showProduct(List<TaoBaoProductBean.Product> list);

    void addProduct(List<TaoBaoProductBean.Product> list);
}
