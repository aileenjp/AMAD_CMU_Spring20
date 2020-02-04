package com.example.list.model;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ItemViewModel extends ViewModel {

    private MutableLiveData<List<Item>> itemList;

    public MutableLiveData<List<Item>> getItemList() {
        if (itemList == null) {
            itemList = new MutableLiveData<>();
        }
        return itemList;
    }
}
