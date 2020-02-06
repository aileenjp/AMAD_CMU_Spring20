package com.example.list.model;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.list.data.SharedPrefsData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private MutableLiveData<List<Item>> itemList;
    private Context context;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public MutableLiveData<List<Item>> getItemList() {
        if (itemList == null) {
            itemList = new MutableLiveData<>();
        }
        return itemList;
    }

    public void loadData(){
        getItemList().setValue(SharedPrefsData.loadData(context));
    }

    public void saveData(){
        SharedPrefsData.saveData(getItemList().getValue(), context);
    }
}
