package com.ody.study;

/**
 * Created by Samuel on 2017/6/9.
 */

public class Book {
    private Author[] authors;
    private String name;

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}