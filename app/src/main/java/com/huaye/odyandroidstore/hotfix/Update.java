package com.huaye.odyandroidstore.hotfix;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Samuel on 2017/4/5.
 */

public class Update extends BmobObject {
    private BmobFile updateFile;

    public BmobFile getUpdateFile() {
        return updateFile;
    }

    public void setUpdateFile(BmobFile updateFile) {
        this.updateFile = updateFile;
    }
}
