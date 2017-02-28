package com.huaye.odyandroidstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected void preOnCreate() {

    }

    protected void init() {

    }

    protected abstract int bindLayout();


    /**
     * 初始化View
     */
    protected abstract void initView();

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        //StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
        // BarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
        init();
        initView();

        initData();
        initListener();
    }
}
