package com.example.list.model;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.list.data.AppRepository;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private LiveData<List<Item>> itemList;
    private Context context;
    private AppRepository appRepository;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        appRepository = AppRepository.getInstance(context);
        //for debugging to clear out the database each time I run the app
        //appRepository.deleteAll();
        itemList = appRepository.getAllItems();
    }

    public LiveData<List<Item>> getItemList() {
        return itemList;
    }

    public void insertItem(Item newItem){
        itemList.getValue().add(newItem);
        appRepository.insertItem(newItem);
    }

    public void deleteItem(Item item){
        appRepository.deleteItem(item);
    }

    public void deleteAll(){
        appRepository.deleteAll();
    }
}
