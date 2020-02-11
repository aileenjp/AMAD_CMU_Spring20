package com.example.list.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity public class Item {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
