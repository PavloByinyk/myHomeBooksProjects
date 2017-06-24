package com.bignerdranch.android.reolm_database;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by 1 on 15.07.2016.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);
    }
}
