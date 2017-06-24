package com.bignerdranch.android.firebasetest.fireBase;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by 1 on 04.07.2016.
 */
public class FireBaseHelper {

    DatabaseReference db;
    Boolean saved=null;
    public FireBaseHelper(DatabaseReference db) {
        this.db = db;
    }
}
