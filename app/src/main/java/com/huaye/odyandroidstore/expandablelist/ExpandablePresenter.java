package com.huaye.odyandroidstore.expandablelist;

import android.os.Environment;

import com.huaye.odyandroidstore.subscribe.ApiSubscriber;
import com.huaye.odyandroidstore.subscribe.SubscriberListener;
import com.huaye.odyandroidstore.utils.TimeUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public class ExpandablePresenter {

    private ExpandView mView;
    private List<FilesMultiEntity> entityList = new ArrayList<>();

    public ExpandablePresenter(ExpandView view) {
        mView = view;
    }

    public void getFiles(final int position, String path) {
        Observable.just(path)
                .map(new Func1<String, Void>() {
                    @Override
                    public Void call(String rootPath) {
                        updateFilesMultiEntity(position, rootPath);
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiSubscriber<Void>(new SubscriberListener<Void>() {
                    @Override
                    public void onNext(Void aVoid) {
                        mView.fillData(position, entityList);
                    }
                }));
    }

    private void updateFilesMultiEntity(int position, String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            FilesMultiEntity entity = new FilesMultiEntity();
            if (file.isFile()) {
                entity.date = TimeUtils.millis2String(file.lastModified());
                entity.itemType = FileAdapter.TYPE_FILE;
            } else {
                entity.itemType = FileAdapter.TYPE_DIRECTORY;
            }
            entity.name = file.getName();
            entity.directory = file.getAbsolutePath();

            if (position < 0) {
                entity.level = 0;
                entityList.add(entity);
            } else if (position < entityList.size()) {
                entity.level = entityList.get(position).level + 1;
                entityList.get(position).addSubItem(entity);
            }

        }
    }

    /**
     * 获取sd卡的绝对路径
     *
     * @return String 如果sd卡存在，返回sd卡的绝对路径，否则返回null
     **/
    public String getSDPath() {
        String sdcard = Environment.getExternalStorageState();
        if (sdcard.equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            return null;
        }
    }

    /**
     * 获取一个基本的路径，一般应用创建存放应用数据可以用到
     *
     * @return String 如果SD卡存在，返回SD卡的绝对路径，如果SD卡不存在，返回Android数据目录的绝对路径
     **/
    public String getBasePath() {
        String basePath = getSDPath();
        if (basePath == null) {
            return Environment.getDataDirectory().getAbsolutePath();
        } else {
            return basePath;
        }
    }


}
