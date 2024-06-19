package com.ara.coursesapp.model;

public class Category {
    private int id;
    private String Title;

    public Category(int id, String title) {
        this.id = id;
        Title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
