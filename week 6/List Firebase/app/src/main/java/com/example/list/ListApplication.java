package com.example.list;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //initialize realm
        Realm.init(this);
        //define realm configuration
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        //for debugging or if you change the db structure and don't want to migrate this will clear out the database
        //Realm.deleteRealm(realmConfig);
        //set default real configuration
        Realm.setDefaultConfiguration(realmConfig);
    }
}
