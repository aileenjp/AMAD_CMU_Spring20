package com.example.list.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.list.model.Item;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository mInstance;

    private AppDatabase mAppDatabase;

    //for background thread
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (mInstance == null){
            mInstance = new AppRepository(context);
        }
        return mInstance;
    }

    private AppRepository(Context context) {
        mAppDatabase = AppDatabase.getInstance(context);
    }

    public LiveData<List<Item>> getAllItems(){
        return mAppDatabase.itemDAO().getAllItems();
    }

    public void insertItem(final Item newItem){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.itemDAO().insertItem(newItem);
            }
        });
    }

    public void deleteItem(final Item newItem){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.itemDAO().deleteItem(newItem);
            }
        });
    }

    public void deleteAll(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.itemDAO().deleteAll();
            }
        });
    }
}
