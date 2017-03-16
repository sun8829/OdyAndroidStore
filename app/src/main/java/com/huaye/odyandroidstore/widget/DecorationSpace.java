package com.huaye.odyandroidstore.widget;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by Samuel on 2017/3/15.
 */

public class DecorationSpace extends RecyclerView.ItemDecoration {

    int left, top, right, bottom;

    /**
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public DecorationSpace(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    /**
     * @param space 传入的值，其单位视为dp
     */
    public DecorationSpace(int space) {
        this.left = space;
        this.top = space;
        this.right = space;
        this.bottom = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof GridLayoutManager || parent.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            int position = parent.getChildAdapterPosition(view);
            if (position % 2 == 0) {
                outRect.left = 0;
                outRect.right = right;
                outRect.top = top;
                outRect.bottom = bottom;
            } else {
                outRect.left = left;
                outRect.right = 0;
                outRect.top = top;
                outRect.bottom = bottom;
            }
        }
    }
}
