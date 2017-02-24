package com.huaye.odyandroidstore.coordinator;

import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/23.
 */

public class CoordinatorNewActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int bindLayout() {
        return R.layout.activity_coordinator_new;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_title, menu);
        return true;
    }
}
