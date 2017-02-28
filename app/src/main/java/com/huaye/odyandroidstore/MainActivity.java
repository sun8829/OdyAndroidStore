package com.huaye.odyandroidstore;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.library.LibraryFragment;
import com.huaye.odyandroidstore.my.MyFragment;
import com.huaye.odyandroidstore.welfare.WelfareFragment;

public class MainActivity extends BaseActivity {
    private LibraryFragment libraryFragment;
    private WelfareFragment welfareFragment;
    private FragmentManager fm;
    private BottomNavigationView navigationView;

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
        navigationView = (BottomNavigationView) findViewById(R.id.nav);

        libraryFragment = new LibraryFragment();
        fm.beginTransaction().replace(R.id.container, libraryFragment).commitAllowingStateLoss();
    }

    @Override
    protected void initListener() {
        super.initListener();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_library:
                        fm.beginTransaction().replace(R.id.container, libraryFragment).commitAllowingStateLoss();
                        break;
                    case R.id.menu_welfare:
                        fm.beginTransaction().replace(R.id.container, new WelfareFragment()).commitAllowingStateLoss();
                        break;
                    case R.id.menu_my:
                        fm.beginTransaction().replace(R.id.container, new MyFragment()).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}
