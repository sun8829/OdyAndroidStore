package com.huaye.odyandroidstore.md;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.utils.BarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/23.
 */

public class CoordinatorMobileActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.main_abl_app_bar)
    AppBarLayout mAblBar;

    @BindView(R.id.main_tv_toolbar_title)
    TextView title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_coordinator_mobile;
    }

    @Override
    protected void initView() {
        BarUtils.setColor(this, Color.parseColor("#5DC9D3"), 0);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mAblBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int halfScroll = appBarLayout.getTotalScrollRange() / 2;
                int offSetAbs = Math.abs(verticalOffset);
                float percentage;
                if (offSetAbs < halfScroll) {
                    title.setText("膜拜单车");
                    percentage = 1 - (float) offSetAbs / (float) halfScroll;
                } else {
                    title.setText("个人中心");
                    percentage = (float) (offSetAbs - halfScroll) / (float) halfScroll;
                }
                toolbar.setAlpha(percentage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_title, menu);
        return true;
    }
}
