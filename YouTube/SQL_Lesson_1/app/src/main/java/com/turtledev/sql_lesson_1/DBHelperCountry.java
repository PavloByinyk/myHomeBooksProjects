package com.turtledev.sql_lesson_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1 on 04.05.2016.
 */
public class DBHelperCountry extends SQLiteOpenHelper {

    public static final String TABLE_COUNTRY="mytable";

    public static final String KEY_ID="_id";
    public static final String KEY_NAME="name";
    public static final String KEY_PEOPLE="people";
    public static final String KEY_REGION="region";

    public DBHelperCountry(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // создаем таблицу с полями
        db.execSQL("create table " +TABLE_COUNTRY+ "("
                +KEY_ID+ " integer primary key autoincrement,"
                +KEY_NAME+ " text,"
                + KEY_PEOPLE + " integer,"
                +KEY_REGION+  " text" + ");");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
