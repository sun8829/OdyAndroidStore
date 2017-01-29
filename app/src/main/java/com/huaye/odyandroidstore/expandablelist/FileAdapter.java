package com.huaye.odyandroidstore.expandablelist;

import android.support.annotation.IntRange;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.utils.ConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public class FileAdapter extends BaseMultiItemQuickAdapter<FilesMultiEntity, BaseViewHolder> {

    public static final int TYPE_FILE = 0;
    public static final int TYPE_DIRECTORY = 1;


    public FileAdapter() {
        this(new ArrayList<FilesMultiEntity>());
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public FileAdapter(List<FilesMultiEntity> data) {
        super(data);
        addItemType(TYPE_FILE, R.layout.item_file);
        addItemType(TYPE_DIRECTORY, R.layout.item_directory);
    }

    @Override
    protected void convert(BaseViewHolder helper, FilesMultiEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_FILE:
                helper.setImageResource(R.id.type_icon, R.mipmap.file)
                        .setText(R.id.date, item.date);
                break;
            case TYPE_DIRECTORY:
                if (item.isExpand) {
                    helper.setImageResource(R.id.arrow, R.mipmap.arrow_down);
                } else {
                    helper.setImageResource(R.id.arrow, R.mipmap.arrow_right);
                }
                helper.setImageResource(R.id.type_icon, R.mipmap.directory);
                break;
        }
        View typeIcon = helper.getView(R.id.type_icon);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) typeIcon.getLayoutParams();

        params.setMargins(ConvertUtils.dp2px(8 * item.level), 0, 0, 0);
        typeIcon.setLayoutParams(params);
        helper.setText(R.id.name, item.name);
    }

    @Override
    public int expand(@IntRange(from = 0L) int position) {
        mData.get(position).isExpand = true;
        return super.expand(position);
    }

    @Override
    public int collapse(@IntRange(from = 0L) int position) {
        mData.get(position).isExpand = false;
        return super.collapse(position);
    }
}
