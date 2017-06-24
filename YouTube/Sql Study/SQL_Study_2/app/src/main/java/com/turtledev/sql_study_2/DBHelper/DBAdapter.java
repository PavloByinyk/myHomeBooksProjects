package com.turtledev.sql_study_2.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.turtledev.sql_study_2.Massage;
import com.turtledev.sql_study_2.pojo.Login;

import java.util.ArrayList;

/**
 * Created by 1 on 27.05.2016.
 */
public class DBAdapter {
    DBHelper dbHelper;

    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context);

    }


    public long insertData(String name, String password) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contenValues = new ContentValues();
        contenValues.put(DBHelper.NAME, name);
        contenValues.put(DBHelper.PASSWORD, password);

        long id = db.insert(DBHelper.TABLE_NAME, null, contenValues);
        return id;


    }

    public ArrayList<Login> getAllData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] columns = {DBHelper.UID, DBHelper.NAME, DBHelper.PASSWORD};
        Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);

        ArrayList<Login> loginList = new ArrayList<Login>();

        while (cursor.moveToNext()) {

            int index1 = cursor.getColumnIndex(DBHelper.UID);
            int id = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(DBHelper.NAME);
            String name = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(DBHelper.PASSWORD);
            String password = cursor.getString(index3);

            Login login = new Login(id, name, password);
            loginList.add(login);
        }
        return loginList;
    }

    public String getData(String name) {

        //зчитує імя введене в поле і вертає по ньому інформацію - імя і пароль

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] columns = {DBHelper.NAME, DBHelper.PASSWORD};
        Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, DBHelper.NAME + " = '" + name + "'", null, null, null, null);

        StringBuffer sb = new StringBuffer();
        while (cursor.moveToNext()) {


            int index2 = cursor.getColumnIndex(DBHelper.NAME);
            String personname = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(DBHelper.PASSWORD);
            String password = cursor.getString(index3);
            sb.append(personname + " " + password + "\n");

        }
        return sb.toString();
    }


    public String getId(String name, String password) {

        //показати id по введеному імені і паролі

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] columns = {DBHelper.UID};
        String[] selectionArgs = {name, password};
        Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, DBHelper.NAME + " =? AND " + DBHelper.PASSWORD + " =?", selectionArgs, null, null, null);

        StringBuffer sb = new StringBuffer();
        while (cursor.moveToNext()) {


            int index1 = cursor.getColumnIndex(DBHelper.UID);
            int id = cursor.getInt(index1);
            sb.append(id + "\n");

        }
        return sb.toString();

    }
    public int updateName(String oldName,String newName){

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBHelper.TABLE_NAME,newName);
        String [] whereArgs={oldName};
        int count=db.update(DBHelper.TABLE_NAME,contentValues,DBHelper.NAME+" =?",whereArgs);
        return count;




    }


    public int deleteRow(String delete){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String[] whereArgs={delete};
        int count=db.delete(DBHelper.TABLE_NAME,DBHelper.NAME+" =?",whereArgs);
        return count;




    }



    class DBHelper extends SQLiteOpenHelper {
        private Context context;

        private static final String DATABASE_NAME = "MyDATABASE";
        private static final String TABLE_NAME = "ChargeDictionaryTABLE";
        private static final int DATABASE_VERSION = 15;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD = "Password";

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + PASSWORD + " VARCHAR(255)) ";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


        public DBHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Massage.massage(context, "Constructor called ");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //CREATE TABLE ChargeDictionaryTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(255));
            try {
                db.execSQL(CREATE_TABLE);
                Massage.massage(context, " onCreate called");
            } catch (SQLException e) {
                Massage.massage(context, " exeption onCreate");

            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                Massage.massage(context, " onUpgrade called");
                onCreate(db);

            } catch (SQLException e) {
                Massage.massage(context, " exeption onUpgrade");

            }


        }
    }


}
