package com.bignerdranch.android.realmdb_wizzard.m_Realm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by 1 on 19.07.2016.
 */
public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    //SAVE
    public void saveData(final Spacecraft spacecraft){

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Spacecraft spacecraft1=realm.copyToRealm(spacecraft);

            }
        });
    }

    //READ

    public ArrayList<String> retrive(){

        ArrayList<String> listNames=new ArrayList<>();
        RealmResults<Spacecraft> spacecraftAll=realm.where(Spacecraft.class).findAll();

        for (Spacecraft s : spacecraftAll){
            listNames.add(s.getName());
        }
        return listNames;

    }
}
