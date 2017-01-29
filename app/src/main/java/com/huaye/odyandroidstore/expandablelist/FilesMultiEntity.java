package com.huaye.odyandroidstore.expandablelist;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public class FilesMultiEntity extends AbstractExpandableItem<FilesMultiEntity> implements MultiItemEntity {

    public int level = 0;
    public int itemType = 0;
    public String name;
    public String date;
    public String directory;
    public boolean isExpand = false;

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
