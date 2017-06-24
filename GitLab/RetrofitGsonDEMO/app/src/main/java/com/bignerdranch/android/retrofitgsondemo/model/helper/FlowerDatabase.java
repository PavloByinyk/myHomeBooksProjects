package com.bignerdranch.android.retrofitgsondemo.model.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bignerdranch.android.retrofitgsondemo.model.Flower;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 24.06.2016.
 */
public class FlowerDatabase extends SQLiteOpenHelper {

    private static final String TAG = FlowerDatabase.class.getSimpleName();

    public FlowerDatabase(Context context) {
        super(context, Constants.DATABASE.DB_NAME, null, Constants.DATABASE.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(Constants.DATABASE.CREATE_TABLE_QUERY);

        }catch (SQLException ex){
            Log.d(TAG,ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Constants.DATABASE.DROP_QUERY);
        this.onCreate(db);
    }

    public void addFlower(Flower flower){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Constants.DATABASE.NAME,flower.getName());
        cv.put(Constants.DATABASE.PRICE,flower.getPrice());
        cv.put(Constants.DATABASE.PRODUCT_ID,flower.getProductId());
        cv.put(Constants.DATABASE.CATEGORY,flower.getCategory());
        cv.put(Constants.DATABASE.INSTRUCTIONS,flower.getInstructions());
        cv.put(Constants.DATABASE.PHOTO,Utils.getPicturesByteOfArray(flower.getPicture()));
        cv.put(Constants.DATABASE.PHOTO_URL,flower.getPhoto());

        try {
            db.insert(Constants.DATABASE.TABLE_NAME,null,cv);

        }catch (Exception e){

        }
        db.close();
    }

    public List<Flower> getFlowers(){
        SQLiteDatabase db=this.getWritableDatabase();

        List<Flower> flowerList=new ArrayList<>();

        Cursor cursor=db.rawQuery(Constants.DATABASE.GET_FLOWERS_QUERY,null);

        if(cursor.getCount()>0){

            if(cursor.moveToFirst()){
                do{

                    Flower flower=new Flower();
                    flower.setName(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.NAME)));
                    flower.setPicture(Utils.getBitmapFromByte(cursor.getBlob(cursor.getColumnIndex(Constants.DATABASE.PHOTO_URL))));

                    flower.setPicture(Utils.getBitmapFromByte(cursor.getBlob(cursor.getColumnIndex(Constants.DATABASE.PHOTO))));
                    flowerList.add(flower);

                }while (cursor.moveToNext());
            }
        }
        return flowerList;
    }
}
