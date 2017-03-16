package com.huaye.odyandroidstore.imitate.taobao;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 2017/3/13.
 */

public class ProductAdapter extends BaseQuickAdapter<TaoBaoProductBean.Product, BaseViewHolder> {
    public ProductAdapter() {
        this(R.layout.item_taobao_product, new ArrayList<TaoBaoProductBean.Product>());
    }

    public ProductAdapter(int layoutResId) {
        super(layoutResId, new ArrayList<TaoBaoProductBean.Product>());
    }

    public ProductAdapter(int layoutResId, List<TaoBaoProductBean.Product> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TaoBaoProductBean.Product item) {
        helper.setText(R.id.price, item.price)
                .setText(R.id.title, item.title)
                .setText(R.id.area, item.area)
                .setText(R.id.act, item.act + "人付款");
        //http://img.alicdn.com/imgextra/i2/1326605018494379751/TB27L5qholnpuFjSZFjXXXTaVXa_!!0-saturn_solar.jpg
        String img;
        if (item.img2.startsWith("http")) {
            img = item.img2;
        } else {
            img = "http:" + item.img2;
        }
        Glide.with(helper.itemView.getContext())
                .load(img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) helper.getView(R.id.img));
    }
}
