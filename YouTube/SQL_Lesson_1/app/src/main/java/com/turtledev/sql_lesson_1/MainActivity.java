package com.turtledev.sql_lesson_1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd,btnRead,btnClear,btnUpdate,btnDelete,btnCountry;
    EditText etName,etEmail,etId;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=(Button)findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        btnRead=(Button)findViewById(R.id.btn_read);
        btnRead.setOnClickListener(this);
        btnClear=(Button)findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
        btnUpdate=(Button)findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(this);
        btnDelete=(Button)findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(this);
        btnCountry=(Button)findViewById(R.id.btnCountry);
        btnCountry.setOnClickListener(this);

        etEmail=(EditText)findViewById(R.id.etMail);
        etName=(EditText)findViewById(R.id.etName);
        etId=(EditText)findViewById(R.id.etID);

        dbHelper=new DBHelper(this);

    }

    @Override
    public void onClick(View v) {

        String name=etName.getText().toString();
        String email=etEmail.getText().toString();
        String id=etId.getText().toString();


        SQLiteDatabase database=dbHelper.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        switch (v.getId()){
            case R.id.btn_add:
                contentValues.put(DBHelper.KEY_NAME,name);
                contentValues.put(DBHelper.KEY_MAIL,email);

                database.insert(DBHelper.TABLE_CONTACTS,null,contentValues);


                break;
            case R.id.btn_read:
                Cursor cursor=database.query(DBHelper.TABLE_CONTACTS,null,null,null,null,null,null);

                if(cursor.moveToFirst()){
                    int idIndex=cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex=cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex=cursor.getColumnIndex(DBHelper.KEY_MAIL);

                    do{
                        Log.d("log", "ID= " + cursor.getInt(idIndex)+
                                ", NAME is "+ cursor.getString(nameIndex)+
                                "EMAIL is "+ cursor.getString(emailIndex));

                    }while(cursor.moveToNext());
                }else{
                    Log.d("log","0 rows");
                }

                cursor.close();

                break;
            case R.id.btn_clear:
                database.delete(DBHelper.TABLE_CONTACTS,null,null);

                break;

            case R.id.btn_update:
                if(id.equals("")){
                    break;
                }
                contentValues.put(DBHelper.KEY_NAME,name);
                contentValues.put(DBHelper.KEY_MAIL,email);

//                String selection=DBHelper.KEY_ID + " Like ?";
//                String[] selectionArgs = { String.valueOf(id) };
//                database.update(
//                        DBHelper.TABLE_CONTACTS,
//                        contentValues,
//                        selection,
//                        selectionArgs);
                database.update(
                        DBHelper.TABLE_CONTACTS,
                        contentValues,
                        DBHelper.KEY_ID + " Like ?",
                        new String []{id});





                break;
            case R.id.btn_delete:
                database.delete(DBHelper.TABLE_CONTACTS,DBHelper.KEY_ID+" = "+id,null);


                break;
            case R.id.btnCountry:
                Intent intent=new Intent(this,Country.class);
                startActivity(intent);
                break;
        }
        dbHelper.close();

    }
}
