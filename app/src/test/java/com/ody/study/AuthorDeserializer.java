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

public class AuthorDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final Author author = new Author();
        author.setId(jsonObject.get("id").getAsInt());
        author.setName(jsonObject.get("name").getAsString());
        return author;
    }
}
