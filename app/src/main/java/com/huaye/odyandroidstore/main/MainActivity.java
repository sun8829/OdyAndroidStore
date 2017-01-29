package com.huaye.odyandroidstore.main;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.expandablelist.ExpandableActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView functionRv;
    private FunctionAdapter adapter;


    @Override
    protected void init() {
        super.init();
        adapter = new FunctionAdapter();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        functionRv = (RecyclerView) findViewById(R.id.functionRv);
        functionRv.setLayoutManager(new LinearLayoutManager(this));
        functionRv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        adapter.setNewData(getData());
    }

    @Override
    protected void initListener() {
        super.initListener();
        functionRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Function function = (Function) adapter.getItem(position);
                startActivity(new Intent(MainActivity.this, function.clazz));
            }
        });
    }

    private List<Function> getData() {
        List<Function> items = new ArrayList<>();
        items.add(new Function("分组伸缩栏(ExpandableList)", ExpandableActivity.class));


        return items;
    }
}
