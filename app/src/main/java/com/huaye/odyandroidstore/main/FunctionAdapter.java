package com.huaye.odyandroidstore.main;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huaye.odyandroidstore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public class FunctionAdapter extends BaseQuickAdapter<Function, BaseViewHolder> {

    public FunctionAdapter() {
        this(R.layout.item_function, new ArrayList<Function>());
    }

    public FunctionAdapter(int layoutResId, List<Function> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Function item) {
        helper.setText(R.id.item, item.getName());
    }
}
