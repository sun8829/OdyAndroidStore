package com.huaye.odyandroidstore.library;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseFragment;
import com.huaye.odyandroidstore.constraint.ConstraintActivity;
import com.huaye.odyandroidstore.customview.CircleMenuActivity;
import com.huaye.odyandroidstore.drawable.ShapeDrawableActivity;
import com.huaye.odyandroidstore.expandablelist.ExpandableActivity;
import com.huaye.odyandroidstore.md.CoordinatorActivity;
import com.huaye.odyandroidstore.md.CoordinatorMobileActivity;
import com.huaye.odyandroidstore.utils.ConvertUtils;
import com.huaye.odyandroidstore.utils.ScreenUtils;
import com.huaye.odyandroidstore.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends BaseFragment {
    private static final String EXTRA_CUSTOM_TABS_SESSION = "android.support.customtabs.extra.SESSION";
    private FunctionPagerAdapter pagerAdapter;
    private ImageView docImg;
    private ViewPager viewPager;
    private List<View> views;
    private List<Function> funList = new ArrayList<>();

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
        layoutParams.setMargins(ConvertUtils.dp2px(16), ConvertUtils.dp2px(48 + 16), ConvertUtils.dp2px(16), ConvertUtils.dp2px(16));
        viewPager.setLayoutParams(layoutParams);
        viewPager.setPageMargin(ConvertUtils.dp2px(8));
        int index = 0;
        funList = getData();
        for (Function function : getData()) {

            CardView cv = (CardView) LayoutInflater.from(mContext).inflate(R.layout.item_vp_fun, null);
//            if (index++ % 2 != 0) {
//                cv.setCardBackgroundColor(Color.parseColor("#DDDDDD"));
//            } else {
//                cv.setCardBackgroundColor(Color.WHITE);
//            }
            ImageView img = (ImageView) cv.findViewById(R.id.img);
            TextView name = (TextView) cv.findViewById(R.id.name);
            TextView des = (TextView) cv.findViewById(R.id.des);
            name.setText(function.getName());
            des.setText(function.getDes());
            if (function.getImgId() > 0) {
                Glide.with(mContext).load(function.getImgId()).diskCacheStrategy(DiskCacheStrategy.ALL).into(img);
            } else {
                Glide.with(mContext).load(function.getImgUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(img);
            }

            cv.setTag(function);
            cv.setOnClickListener(new View.OnClickListener() {
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
            views.add(cv);
        }

        pagerAdapter = new FunctionPagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
    }

    @Override
    protected void initData() {
        super.initData();
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
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View view) {
                String url = funList.get(viewPager.getCurrentItem()).getDocUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Bundle extras = new Bundle();
                extras.putBinder(EXTRA_CUSTOM_TABS_SESSION, null);
                intent.putExtras(extras);
                startActivity(intent);
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

        items.add(new Function()
                .setDocUrl("http://www.jianshu.com/p/34b35a8c0a1c")
                .setImgUrl("http://bmob-cdn-9267.b0.upaiyun.com/2017/03/10/490877fa40a9614e80f5ce50c0a7668e.gif")
                .setName("圆形菜单")
                .setClazz(CircleMenuActivity.class));

        items.add(new Function()
                .setDocUrl("https://github.com/samuelhuahui/OdyAndroidStore/wiki")
                .setImgUrl("http://bmob-cdn-9267.b0.upaiyun.com/2017/02/28/1d793194404e4c9d80a86aaf1052833d.gif")
                .setName("CoordinatorLayout进阶")
                .setClazz(CoordinatorActivity.class));

        items.add(new Function()
                .setDocUrl("https://github.com/samuelhuahui/OdyAndroidStore/wiki")
                .setImgUrl("http://bmob-cdn-9267.b0.upaiyun.com/2017/02/28/4918bfd640d30bf080ccaa943de45af3.gif")
                .setName("CoordinatorLayout使用(高仿【摩拜单车】个人中心)")
                .setClazz(CoordinatorMobileActivity.class));

        items.add(new Function()
                .setDocUrl("https://github.com/samuelhuahui/OdyAndroidStore/wiki")
                .setImgUrl("http://bmob-cdn-9267.b0.upaiyun.com/2017/02/24/752b41ef403f1df280eca1229628fb88.png")
                .setName("shape使用总结")
                .setClazz(ShapeDrawableActivity.class));

        items.add(new Function()
                .setDocUrl("http://www.jianshu.com/p/b3cd72524b11")
                .setImgUrl("http://bmob-cdn-9150.b0.upaiyun.com/2017/02/19/8a52a75640d5f75080b6f96ba424428d.gif")
                .setName("ConstraintLayout实战")
                .setClazz(ConstraintActivity.class));


        items.add(new Function()
                .setDocUrl("http://www.jianshu.com/p/027395fd3c67")
                .setImgUrl("http://upload-images.jianshu.io/upload_images/4751442-02adb2faf95c9bd7.png?imageMogr2/auto-orient/strip%7CimageView2/2")
                .setName("比ExpandableListView更强大的分组列表实现")
                .setClazz(ExpandableActivity.class));

        return items;
    }
}
