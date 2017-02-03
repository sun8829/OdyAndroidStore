package com.huaye.odyandroidstore.main;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public class Function {
    public int imgId;
    public String name;
    public String des;
    public String extra;
    public Class<?> clazz;

    public Function(int imgId, String name, String des, String extra, Class<?> clazz) {
        this.imgId = imgId;
        this.name = name;
        this.des = des;
        this.extra = extra;
        this.clazz = clazz;
    }

    public Function(int imgId, String name, String des, Class<?> clazz) {
        this.imgId = imgId;
        this.name = name;
        this.des = des;
        this.clazz = clazz;
    }
}
