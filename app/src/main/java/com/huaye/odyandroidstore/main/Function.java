package com.huaye.odyandroidstore.main;

/**
 * Created by sunhuahui on 2017/1/28.
 */

public class Function {
    private int imgId;
    private String docUrl;
    private String imgUrl;
    private String name;
    private String des;
    private String extra;
    private Class<?> clazz;

    public Function() {
    }

    public Function(int imgId, String name, String des, String extra, Class<?> clazz) {
        this.imgId = imgId;
        this.name = name;
        this.des = des;
        this.extra = extra;
        this.clazz = clazz;
    }

    public Function(String imgUrl, String name, String des, String extra, Class<?> clazz) {
        this.imgUrl = imgUrl;
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

    public int getImgId() {
        return imgId;
    }

    public Function setImgId(int imgId) {
        this.imgId = imgId;
        return this;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public Function setDocUrl(String docUrl) {
        this.docUrl = docUrl;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Function setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public Function setName(String name) {
        this.name = name;
        return this;
    }

    public String getDes() {
        return des;
    }

    public Function setDes(String des) {
        this.des = des;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public Function setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Function setClazz(Class<?> clazz) {
        this.clazz = clazz;
        return this;
    }
}
