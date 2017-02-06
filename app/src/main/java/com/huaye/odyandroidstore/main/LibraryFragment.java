package com.huaye.odyandroidstore.main;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseFragment;
import com.huaye.odyandroidstore.expandablelist.ExpandableActivity;
import com.huaye.odyandroidstore.utils.ConvertUtils;
import com.huaye.odyandroidstore.utils.ScreenUtils;
import com.huaye.odyandroidstore.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends BaseFragment {

    private RecyclerView functionRv;
    private FunctionAdapter adapter;
    private FunctionPagerAdapter pagerAdapter;
    private WebView wv;
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
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        wv = (WebView) view.findViewById(R.id.wv);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewPager.getLayoutParams();
        layoutParams.width = ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(80);
        layoutParams.setMargins(ConvertUtils.dp2px(16), 0, ConvertUtils.dp2px(16), 0);
        viewPager.setLayoutParams(layoutParams);

        functionRv = (RecyclerView) view.findViewById(R.id.functionRv);
        functionRv.setLayoutManager(new LinearLayoutManager(mContext));
        functionRv.setAdapter(adapter);

        for (Function function : getData()) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_vp_fun, null);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView des = (TextView) v.findViewById(R.id.des);
            name.setText(function.getName());
            des.setText(function.getDes());
            if (function.getImgId() > 0) {
                Glide.with(this).load(function.getImgId()).centerCrop().into(img);
            } else if (!StringUtils.isEmpty(function.getImgUrl())) {
                Glide.with(this).load(function.getImgUrl()).into(img);
            }

            v.setTag(function);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Function f = (Function) view.getTag();
                    if (f.getClazz() == null) return;
                    Intent intent = new Intent(mContext, f.getClazz());
                    if (!StringUtils.isEmpty(f.getExtra())) {
                        intent.putExtra("extra", f.getExtra());
                    }
                    startActivity(intent);
                }
            });
            views.add(v);
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
                Intent intent = new Intent(mContext, function.getClazz());
                if (function.getExtra() != null) {
                    intent.putExtra("extra", function.getExtra());
                }
                startActivity(intent);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                List<Function> fs = getData();
                if (fs != null && fs.size() > 0 && position < fs.size()) {
                    Function f = fs.get(position);
                    if (f != null) {
                        wv.loadUrl(f.getDocUrl());
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private List<Function> getData() {
        List<Function> items = new ArrayList<>();
        //items.add(new Function(R.mipmap.exp, "文件管理器", "分组列表", ExpandableActivity.class));
        items.add(new Function()
                .setDocUrl("https://github.com/samuelhuahui/OdyAndroidStore/wiki")
                .setImgId(R.mipmap.exp)
                .setName("文件管理器")
                .setDes("分组列表")
                .setClazz(ExpandableActivity.class));

        //items.add(new Function("https://user-gold-cdn.xitu.io/2017/2/3/96dd3821afded53cc0d74e273bd611dd", "布局", "ConstraintLayout", "https://gold.xitu.io/entry/589461bd8d6d81006c4d7fe4", WebActivity.class));
        items.add(new Function()
                .setDocUrl("https://gold.xitu.io/entry/589461bd8d6d81006c4d7fe4")
                .setImgUrl("https://user-gold-cdn.xitu.io/2017/2/3/96dd3821afded53cc0d74e273bd611dd")
                .setName("布局")
                .setDes("ConstraintLayout解析"));

        items.add(new Function()
                .setDocUrl("https://github.com/samuelhuahui/OdyAndroidStore/wiki")
                .setImgId(R.mipmap.exp)
                .setName("文件管理器")
                .setDes("分组列表")
                .setClazz(ExpandableActivity.class));

        items.add(new Function()
                .setDocUrl("https://github.com/samuelhuahui/OdyAndroidStore/wiki")
                .setImgId(R.mipmap.exp)
                .setName("文件管理器")
                .setDes("分组列表")
                .setClazz(ExpandableActivity.class));

        return items;
    }
}
