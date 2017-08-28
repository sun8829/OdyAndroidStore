package com.ody.study;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sunhuahui on 2017/8/11.
 */

public class PPDTest {

    @Test
    public void test() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .takeUntil(new Func1<Long, Boolean>() {
                    @Override
                    public Boolean call(Long aLong) {
                        return true;
                    }
                })
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println("long : " + aLong);
                    }
                });
    }
}
