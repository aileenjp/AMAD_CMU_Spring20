package com.example.list.model;

import androidx.room.PrimaryKey;

import java.util.UUID;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

@RealmClass
public class Item implements RealmModel {

    @PrimaryKey public String id = UUID.randomUUID().toString();
    private String name;

    public Item(){}

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
