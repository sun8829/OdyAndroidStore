package com.ody.study;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Samuel on 2017/6/9.
 */

public class BookDeserializer implements JsonDeserializer<Book> {
    @Override
    public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final JsonElement jsonTitle = jsonObject.get("name");
        final String name = jsonTitle.getAsString();

        JsonElement jsonAuthors = jsonObject.get("authors");

        final Book book = new Book();
        if (jsonAuthors.isJsonArray()) {//如果数组类型，此种情况是我们需要的
            Author[] authors = context.deserialize(jsonAuthors, Author[].class);
            book.setAuthors(authors);
        } else {//此种情况为无效情况
            book.setAuthors(null);
        }

        book.setName(name);
        return book;
    }

}
