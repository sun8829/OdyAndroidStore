package com.ody.study.designpatterns.singleton;

/**
 * Created by sunhuahui on 2017/8/28.
 */

public class LazySingleton {
    private static LazySingleton INSTANCE = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
