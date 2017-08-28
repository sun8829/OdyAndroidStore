package com.ody.study.designpatterns.singleton;

/**
 * Created by sunhuahui on 2017/8/28.
 */

public enum EnumSingleton {
    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
