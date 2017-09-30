package com.ody.study.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

/**
 * Created by sunhuahui on 2017/9/18.
 */

public class NullStringToEmpty {

    @Test
    public void app() {
        String json = "{\"name\":null, \"date\":\"1986\"}";
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        //然后用上面一行写的gson来序列化和反序列化实体类type
        Book book = gson.fromJson(json, Book.class);
        System.out.println(book.getName());
        System.out.println(book.getDate());
    }
}
