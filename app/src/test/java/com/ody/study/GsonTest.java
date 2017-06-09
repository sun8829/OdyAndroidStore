package com.ody.study;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

/**
 * Created by Samuel on 2017/6/9.
 */

public class GsonTest {
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
}
