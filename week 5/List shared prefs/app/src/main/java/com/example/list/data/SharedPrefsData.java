package com.example.list.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.list.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SharedPrefsData {
    private final static String PREFS_NAME = "ITEMS";

    public static void saveData(List<Item> itemList, Context context) {
        //get access to a shared preferences file
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //create an editor to write to the shared preferences file
        SharedPreferences.Editor editor = sharedPrefs.edit();
        //add size to the editor
        editor.putInt("size", itemList.size());
        //add items to the editor
        for (int i = 0; i < itemList.size(); i++) {
            editor.putString("item" + i, itemList.get(i).getName());
        }
        //save the data
        editor.apply();
    }

    public static List<Item> loadData(Context context) {
        List<Item> itemList = new ArrayList<>();
        //get access to a shared preferences file
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        int size = sharedPrefs.getInt("size", 0);

        for (int i = 0; i < size; i++) {
            itemList.add(new Item(sharedPrefs.getString("item" + i, "")));
        }
        return itemList;
    }
}