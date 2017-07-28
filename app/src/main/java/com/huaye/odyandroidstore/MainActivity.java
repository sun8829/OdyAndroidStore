package com.huaye.odyandroidstore;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.library.LibraryFragment;
import com.huaye.odyandroidstore.my.MyFragment;
import com.huaye.odyandroidstore.welfare.WelfareFragment;

import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends BaseActivity {
    private LibraryFragment libraryFragment;
    private WelfareFragment welfareFragment;
    private MyFragment myFragment;
    private FragmentManager fm;
    private BottomNavigationView navigationView;

    @Override
    protected void init() {
        super.init();
        fm = getSupportFragmentManager();
        Bmob.initialize(this, "c1bc52fe17266edafa7b25b1ccf4edbd");
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        navigationView = (BottomNavigationView) findViewById(R.id.nav);
        libraryFragment = new LibraryFragment();
        if (libraryFragment.isAdded()) {
            fm.beginTransaction().show(libraryFragment).commit();
        } else {
            fm.beginTransaction().add(R.id.container, libraryFragment).commit();
        }
    }

    private void switchFragment(Fragment fragment) {
        List<Fragment> fragments = fm.getFragments();
        for (Fragment f : fragments) {
            if (!f.equals(fragment) && !f.isHidden()) {
                fm.beginTransaction().hide(f).commit();
            }
        }
        if (fragment.isAdded()) {
            fm.beginTransaction().show(fragment).commit();
        } else {
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_library:
                        switchFragment(libraryFragment);
                        break;
                    case R.id.menu_welfare:
                        if (welfareFragment == null){
                            welfareFragment = new WelfareFragment();
                        }
                        switchFragment(welfareFragment);
                        break;
                    case R.id.menu_my:
                        if (myFragment == null){
                            myFragment = new MyFragment();
                        }
                        switchFragment(myFragment);
                        break;
                }
                return true;
            }
        });

        ARouter.getInstance().build("/xxx/xxx").navigation(this, new NavCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.d("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.d("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.d("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.d("ARouter", "被拦截了");
            }
        });

        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentPreAttached(FragmentManager fm, Fragment f, Context context) {
                super.onFragmentPreAttached(fm, f, context);
            }

            @Override
            public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
                super.onFragmentAttached(fm, f, context);
            }

            @Override
            public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                super.onFragmentCreated(fm, f, savedInstanceState);
            }

            @Override
            public void onFragmentActivityCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                super.onFragmentActivityCreated(fm, f, savedInstanceState);
            }

            @Override
            public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
                super.onFragmentViewCreated(fm, f, v, savedInstanceState);
            }

            @Override
            public void onFragmentStarted(FragmentManager fm, Fragment f) {
                super.onFragmentStarted(fm, f);
            }

            @Override
            public void onFragmentResumed(FragmentManager fm, Fragment f) {
                super.onFragmentResumed(fm, f);
            }

            @Override
            public void onFragmentPaused(FragmentManager fm, Fragment f) {
                super.onFragmentPaused(fm, f);
            }

            @Override
            public void onFragmentStopped(FragmentManager fm, Fragment f) {
                super.onFragmentStopped(fm, f);
            }

            @Override
            public void onFragmentSaveInstanceState(FragmentManager fm, Fragment f, Bundle outState) {
                super.onFragmentSaveInstanceState(fm, f, outState);
            }

            @Override
            public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
                super.onFragmentViewDestroyed(fm, f);
            }

            @Override
            public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
                super.onFragmentDestroyed(fm, f);
            }

            @Override
            public void onFragmentDetached(FragmentManager fm, Fragment f) {
                super.onFragmentDetached(fm, f);
            }
        }, true);
    }
}
