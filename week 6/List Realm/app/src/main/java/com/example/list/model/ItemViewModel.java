package com.example.list.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.list.data.ItemDAO;

import io.realm.RealmResults;

public class ItemViewModel extends ViewModel {

    private LiveData<RealmResults<Item>> itemList;
    private ItemDAO itemDAO;

    public ItemViewModel() {
        itemDAO = new ItemDAO();
        itemList = itemDAO.getAllItems();
    }

    public LiveData<RealmResults<Item>> getItemList() {
        return itemList;
    }

    public void insertItem(String name){
        itemDAO.insertItem(name);
    }

    public void deleteItem(Item item){
        itemDAO.deleteItem(item.getId());
    }

    public void deleteAll(){
        itemDAO.deleteAll();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        itemDAO.close();
    }
}
