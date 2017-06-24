package com.turtledev.chargedb_demo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 1 on 28.05.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    //DB
    private static final String DATABASE_NAME = "DBCharges";
    private static final String TABLE_NAME = "TableCharges";
    private static final int DB_VERSION = 2;

    //columns
    private static final String ROW_ID ="_id";
    private static final String NAME = "Name";
    private static final String SUM = "Sum";

    //CreateTable
    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + " ( " + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +" VARCHAR(255), " + SUM + " DOUBLE DEFAULT 0);";

    //Drop Table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"CREATE DB SUCCESS",Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context,"ERROR CREATE DB"+e,Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context,"SUCCESS UPDATE DB",Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context,"ERROR UPDATE DB"+e,Toast.LENGTH_SHORT).show();
        }

    }
}
