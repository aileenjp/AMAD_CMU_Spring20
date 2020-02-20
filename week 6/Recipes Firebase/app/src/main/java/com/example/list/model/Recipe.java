package com.example.list.model;

public class Recipe {
    private String name;
    private String url;

    public Recipe(){
        // Default constructor
    }

    public Recipe(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName(){
        return name;
    }

    public String geturl(){
        return url;
    }
}