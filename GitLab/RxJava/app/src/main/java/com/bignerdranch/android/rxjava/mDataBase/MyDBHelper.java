package com.bignerdranch.android.rxjava.mDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bignerdranch.android.rxjava.Charge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by 1 on 13.10.2016.
 */

public class MyDBHelper {

    Context mContext;
    //private DBHelper dbHelper;
    private SQLiteDatabase db;
    private static MyDBHelper dbAdapter;


    public MyDBHelper(Context AppContext) {
        this.mContext = AppContext.getApplicationContext();
        //dbHelper = new DBHelper(mContext);
        db =new DBHelper(mContext).getWritableDatabase();

    }

    public static MyDBHelper getDbAdapter(Context context){

        if(dbAdapter == null) {
            dbAdapter = new MyDBHelper(context.getApplicationContext());
        }
        return dbAdapter;
    }


    public Callable<List<Charge>> getUsers() {
        return new Callable<List<Charge>>() {
            @Override
            public List<Charge> call() {
                // select * from users where _id is userId
                String[] columns = {DBHelper.CHARGE_NAME, DBHelper.CHARGE_ID};
                Cursor cursor = db.query(DBHelper.CHARGE_TABLE_NAME, columns, null, null, null, null, null);
                ArrayList<Charge> listCharges = new ArrayList<Charge>();
                while (cursor.moveToNext()) {

                    int index1 = cursor.getColumnIndex(DBHelper.CHARGE_NAME);
                    int index2 = cursor.getColumnIndex(DBHelper.CHARGE_ID);
                    String id = cursor.getString(index2);
                    String name = cursor.getString(index1);
                    Charge charges = new Charge();
                    charges.setName(name);
                    charges.setId(id);
                    listCharges.add(charges);
                }
                cursor.close();

                return listCharges;
            }
        };
    }

    public Observable<List<Charge>> getUsers1() {

        return makeObservable(getUsers())
                .subscribeOn(Schedulers.io()); // note: do not use Schedulers.io()

    }

    public static  <T> Observable<T> makeObservable(final Callable<T> func) {
        return Observable.create(
                new Observable.OnSubscribe<T>() {
                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        try {
                            subscriber.onNext(func.call());
                        } catch (Exception ex) {
                            Log.e(TAG, "Error reading from the database", ex);
                        }
                    }
                });
    }


//    public List<Charge> dBListCharges() {
//        String[] columns = {DBHelper.CHARGE_NAME, DBHelper.CHARGE_ID};
//        Cursor cursor = db.query(DBHelper.CHARGE_TABLE_NAME, columns, null, null, null, null, null);
//        ArrayList<Charge> listCharges = new ArrayList<Charge>();
//        while (cursor.moveToNext()) {
//
//            int index1 = cursor.getColumnIndex(DBHelper.CHARGE_NAME);
//            int index2 = cursor.getColumnIndex(DBHelper.CHARGE_ID);
//            String id = cursor.getString(index2);
//            String name = cursor.getString(index1);
//            Charge charges = new Charge();
//            charges.setName(name);
//            charges.setId(id);
//            listCharges.add(charges);
//        }
//        cursor.close();
//
//        return listCharges;
//    }

//    public void insertServerDataChargesToDB(List<Charge> list) {
//
//
//        ContentValues contenValues;
//        for (int i = 0; i < list.size(); i++) {
//            contenValues = new ContentValues();
//            if (list.get(i).getName() != null) {
//                String name = list.get(i).getName().toString();
//                String id = list.get(i).getId().toString();
//                contenValues.put(DBHelper.CHARGE_ID, id);
//                contenValues.put(DBHelper.CHARGE_NAME, name);
//                db.insertWithOnConflict(DBHelper.CHARGE_TABLE_NAME, null, contenValues, SQLiteDatabase.CONFLICT_IGNORE);
//
//            }
//
//        }
//
//
//    }

    public void loadTodb(List<Charge> list) {

        Observable.just(list)
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<List<Charge>>() {

                    @Override
                    public void call(List<Charge> charges) {

                        ContentValues contenValues;
                        for (int i = 0; i < charges.size(); i++) {
                            contenValues = new ContentValues();
                            if (charges.get(i).getName() != null) {
                                String name = charges.get(i).getName().toString();
                                String id = charges.get(i).getId().toString();
                                contenValues.put(DBHelper.CHARGE_ID, id);
                                contenValues.put(DBHelper.CHARGE_NAME, name);
                                db.insertWithOnConflict(DBHelper.CHARGE_TABLE_NAME, null, contenValues, SQLiteDatabase.CONFLICT_IGNORE);

                            }

                        }

                        //insertServerDataChargesToDB(charges);
                        //Thread.currentThread().getName().toString();
                        Log.e(TAG, "Дані загружені в бд" + Thread.currentThread().getName().toString());
                    }
                });


    }
}
