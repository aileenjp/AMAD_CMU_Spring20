package com.example.list.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.list.model.Item;

import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class ItemDAO {
    private Realm realmDb;

    public ItemDAO(){
        this.realmDb = Realm.getDefaultInstance();
    }

    public RealmLiveData<Item> getAllItems(){
        return new RealmLiveData(realmDb.where(Item.class).findAllAsync());
    }

    public void insertItem(final String name){
        final Item newItem = new Item(name);
        //start realm write transaction
        realmDb.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //create realm object
                realm.copyToRealm(newItem);
            }
        });
    }

    public void deleteItem(final String id){
        realmDb.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //finds and deletes the realm object
                realm.where(Item.class).equalTo("id", id).findAll().deleteAllFromRealm();
            }
        });
    }

    public void deleteAll(){
        //start realm write transaction
        realmDb.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }

    public void close(){
        realmDb.close();
    }
}
