package com.ody.study;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ody.study.util.LoggerFactory;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samuel on 2017/6/9.
 */

public class GsonTest {
    private LoggerFactory logger = LoggerFactory.INSTANCE;

    @Test
    public void emptyObjTest() {
        String data = "{\n" +
                "  'name':    'java',\n" +
                "  'authors':  ''\n" +
                "}";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Book.class, new BookDeserializer())
//                .registerTypeAdapter(Author.class, new AuthorDeserializer())
                .create();
        try {
            Book book = gson.fromJson(data, Book.class);
            if (book.getAuthors() == null) {
                System.out.println("空");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void convertTest() {
        String data = "{'price':'16.23630', 'author': '孙华辉'}";
        Bean bean = new Gson().fromJson(data, Bean.class);
        logger.info("price {}", bean.price * 100);
    }

    @Test
    public void nullToEmptyString() {
        Gson gson = new Gson();
        Map<String, Object> params = new HashMap<>();
        HashMap<String, Object> json = new HashMap<>();
        json.put("app_channelsid", "ppd");
        json.put("AppId", "123456878");
        json.put("app_feature", "ppd" + "_" + "yingyongbao");
        params.put("ExtroInfo", json);//注册

        System.out.println(gson.toJson(params));
    }

    public static class Bean {
        public float price;
        public String author;
    }
}
