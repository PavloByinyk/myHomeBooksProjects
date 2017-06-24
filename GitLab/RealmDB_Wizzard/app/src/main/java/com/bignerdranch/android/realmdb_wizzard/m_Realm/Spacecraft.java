package com.bignerdranch.android.realmdb_wizzard.m_Realm;

import io.realm.RealmObject;

/**
 * Created by 1 on 19.07.2016.
 */
public class Spacecraft extends RealmObject {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
