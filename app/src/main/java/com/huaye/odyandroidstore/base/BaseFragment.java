package com.huaye.odyandroidstore.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sunhuahui on 2017/1/30.
 */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;

    protected void init() {

    }

    protected abstract int bindLayout();


    /**
     * 初始化View
     */
    protected abstract void initView(View view);

    /**
     * 数据初始化
     */
    protected void initData() {

    }

    /**
     * 添加监听
     */
    protected void initListener() {
    }

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initData();
        initListener();
        super.onViewCreated(view, savedInstanceState);
    }
}
