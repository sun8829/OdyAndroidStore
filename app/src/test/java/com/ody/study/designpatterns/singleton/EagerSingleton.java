package com.ody.study.designpatterns.singleton;

/**
 * Created by sunhuahui on 2017/8/28.
 */

public class EagerSingleton {
    public static final EagerSingleton INSTANCE = new EagerSingleton(); //静态的final的MaYun

    private EagerSingleton() {
        //MaYun诞生要做的事情
    }
}
