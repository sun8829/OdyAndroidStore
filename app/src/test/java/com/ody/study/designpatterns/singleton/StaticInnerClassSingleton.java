package com.ody.study.designpatterns.singleton;

/**
 * Created by sunhuahui on 2017/8/28.
 */

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }


    public static StaticInnerClassSingleton getInstance() {
        return HelperHolder.INSTANCE;
    }

    private static class HelperHolder {
        private static final StaticInnerClassSingleton INSTANCE =
                new StaticInnerClassSingleton();
    }
}
