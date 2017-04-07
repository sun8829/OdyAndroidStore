package com.huaye.odyandroidstore.imitate.lyf.home;

import android.support.v7.widget.RecyclerView;

import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LYFHomeActivity extends BaseActivity {
    @BindView(R.id.rv)
    RecyclerView rv;

    @BindView(R.id.refreshLay)
    RecyclerRefreshLayout refreshLay;

    @Override
    protected int bindLayout() {
        return R.layout.activity_lyfhome;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }
}
