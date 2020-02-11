package com.example.list.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.list.model.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("SELECT * FROM Item")
    LiveData<List<Item>> getAllItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(Item item);

    @Delete
    void deleteItem(Item item);

    @Query("DELETE FROM Item")
    int deleteAll();
}
