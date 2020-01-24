package com.example.tulips.model;

public class Character {
    private String name;
    private String picture;
    private String info;

    public Character(String name, String picture, String info) {
        this.name = name;
        this.picture = picture;
        this.info = info;
    }

    public Character(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
