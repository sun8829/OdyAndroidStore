package com.ody.study.designpatterns.singleton;

/**
 * Created by sunhuahui on 2017/8/28.
 */

public class LazyPlusSingleton {

    private volatile static LazyPlusSingleton INSTANCE;

    private LazyPlusSingleton() {
    }

    public static LazyPlusSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyPlusSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyPlusSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
