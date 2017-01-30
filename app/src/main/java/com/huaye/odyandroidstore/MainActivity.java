package com.huaye.odyandroidstore;

import android.support.v4.app.FragmentManager;

import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.main.LibraryFragment;

public class MainActivity extends BaseActivity {
    private LibraryFragment libraryFragment;
    private FragmentManager fm;


    @Override
    protected void init() {
        super.init();
        fm = getSupportFragmentManager();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        libraryFragment = new LibraryFragment();
        fm.beginTransaction().replace(R.id.container, libraryFragment).commitAllowingStateLoss();
    }
}
