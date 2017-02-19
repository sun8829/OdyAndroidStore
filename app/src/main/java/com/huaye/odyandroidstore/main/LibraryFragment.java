package com.huaye.odyandroidstore.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseFragment;
import com.huaye.odyandroidstore.expandablelist.ExpandableActivity;
import com.huaye.odyandroidstore.utils.ConvertUtils;
import com.huaye.odyandroidstore.utils.ScreenUtils;
import com.huaye.odyandroidstore.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends BaseFragment {

    private FunctionPagerAdapter pagerAdapter;
    private ImageView docImg;
    private ViewPager viewPager;
    private List<View> views;

    @Override
    protected void init() {
        super.init();
        views = new ArrayList<>();
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        docImg = (ImageView) view.findViewById(R.id.docImg);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) viewPager.getLayoutParams();
        layoutParams.width = ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(80);
        //layoutParams.setMargins(ConvertUtils.dp2px(16), ConvertUtils.dp2px(48 + 16), ConvertUtils.dp2px(16), ConvertUtils.dp2px(16));
        viewPager.setLayoutParams(layoutParams);
        int index = 0;
        for (Function function : getData()) {

            View v = LayoutInflater.from(mContext).inflate(R.layout.item_vp_fun, null);
            CardView cv = (CardView) v.findViewById(R.id.cardView);
            if (index++ % 2 != 0) {
                cv.setCardBackgroundColor(Color.parseColor("#DDDDDD"));
            } else {
                cv.setCardBackgroundColor(Color.WHITE);
            }
            ImageView img = (ImageView) v.findViewById(R.id.img);
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView des = (TextView) v.findViewById(R.id.des);
            name.setText(function.getName());
            des.setText(function.getDes());
            if (function.getImgId() > 0) {
                Glide.with(mContext).load(function.getImgId()).into(img);
            } else {
                Glide.with(mContext).load(function.getImgUrl()).into(img);
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
    protected void initListener() {
        super.initListener();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        docImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_title, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
                .setImgUrl("http://bmob-cdn-9150.b0.upaiyun.com/2017/02/19/8a52a75640d5f75080b6f96ba424428d.gif")
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
