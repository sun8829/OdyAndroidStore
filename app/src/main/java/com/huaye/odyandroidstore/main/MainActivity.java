package com.huaye.odyandroidstore.main;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.expandablelist.ExpandableActivity;
import com.huaye.odyandroidstore.utils.ConvertUtils;
import com.huaye.odyandroidstore.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView functionRv;
    private FunctionAdapter adapter;
    private FunctionPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private List<View> views;

    @Override
    protected void init() {
        super.init();
        adapter = new FunctionAdapter();
        views = new ArrayList<>();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewPager.getLayoutParams();
        layoutParams.width = ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(80);
        layoutParams.setMargins(ConvertUtils.dp2px(16), 0, ConvertUtils.dp2px(16), 0);
        viewPager.setLayoutParams(layoutParams);

        functionRv = (RecyclerView) findViewById(R.id.functionRv);
        functionRv.setLayoutManager(new LinearLayoutManager(this));
        functionRv.setAdapter(adapter);

        for (Function function : getData()) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_vp_fun, null);
            ImageView img = (ImageView) view.findViewById(R.id.img);
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView des = (TextView) view.findViewById(R.id.des);
            name.setText(function.name);
            des.setText(function.des);
            view.setTag(function);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Function f = (Function) view.getTag();
                    startActivity(new Intent(MainActivity.this, f.clazz));
                }
            });
            views.add(view);
        }

        pagerAdapter = new FunctionPagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
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
        items.add(new Function("文件管理器", "分组列表", ExpandableActivity.class));
        items.add(new Function("文件管理器", "分组列表", ExpandableActivity.class));
        items.add(new Function("文件管理器", "分组列表", ExpandableActivity.class));
        items.add(new Function("文件管理器", "分组列表", ExpandableActivity.class));
        return items;
    }
}
