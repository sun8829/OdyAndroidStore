package com.ody.study.designpatterns.singleton;

/**
 * Created by sunhuahui on 2017/8/28.
 */

public class EagerPlusSingleton {
    private static EagerPlusSingleton INSTANCE = null;

    static {
        INSTANCE = new EagerPlusSingleton();
    }

    private EagerPlusSingleton() {
    }

    public static EagerPlusSingleton getInstance() {
        return INSTANCE;
    }

}
