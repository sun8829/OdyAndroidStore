package com.huaye.odyandroidstore.main;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by sunhuahui on 2017/1/29.
 */

public class FunctionPagerAdapter extends PagerAdapter {
    private List<View> mViewList;

    public FunctionPagerAdapter(List<View> mViewList) {
        this.mViewList = mViewList;
    }

    @Override
    public int getCount() {//必须实现
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//必须实现
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        View view = mViewList.get(position);
        if (view.getParent() != null) {
            container.removeView(view);
        }
        container.addView(view);
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        container.removeView(mViewList.get(position));
    }
}
