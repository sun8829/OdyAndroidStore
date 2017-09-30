package com.huaye.odyandroidstore.md;

import android.support.design.widget.AppBarLayout;
import android.widget.LinearLayout;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinatorPuckerActivity extends BaseActivity {
    @BindView(R.id.app_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.lin1)
    LinearLayout mLin1;
    @BindView(R.id.lin2)
    LinearLayout mLin2;

    @Override
    protected int bindLayout() {
        return R.layout.activity_ppd;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int height = appBarLayout.getTotalScrollRange();
                int offSetAbs = Math.abs(verticalOffset);
                float p = (float) offSetAbs / (float) height;
                mLin1.setAlpha(1 - p);
                if ((1 - p) > 0.5) {
                    mLin2.setAlpha(1 - p);
                    mAppBarLayout.setAlpha(1 - p);
                } else {
                    mLin2.setAlpha(p);
                    mAppBarLayout.setAlpha(p);
                }
            }
        });
    }
}
