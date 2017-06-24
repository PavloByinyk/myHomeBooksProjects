package com.turtledev.sql_lesson_1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Country extends AppCompatActivity implements View.OnClickListener {
    final String LOG_TAG = "myLogs";


    Button btnAll,btnFunction,btnPeople,btnRegionPeople,btnRegionPeoplePlus,btnSort;
    EditText etFunction,etNaselennya,etRegionPlus;
    RadioGroup radioGroup;

    DBHelperCountry dbHelperCountry;
    SQLiteDatabase db;



    String name[] = { "Китай", "США", "Бразилия", "Россия", "Япония",
            "Германия", "Египет", "Италия", "Франция", "Канада" };
    int people[] = { 1400, 311, 195, 142, 128, 82, 80, 60, 66, 35 };
    String region[] = { "Азия", "Америка", "Америка", "Европа", "Азия",
            "Европа", "Африка", "Европа", "Европа", "Америка" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        btnAll=(Button)findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);
        btnFunction=(Button)findViewById(R.id.btnFunctions);
        btnFunction.setOnClickListener(this);
        btnPeople=(Button)findViewById(R.id.btnPeople);
        btnPeople.setOnClickListener(this);
        btnRegionPeople=(Button)findViewById(R.id.btnRegionPeople);
        btnRegionPeople.setOnClickListener(this);
        btnRegionPeoplePlus=(Button)findViewById(R.id.btnRegionPeoplePlus);
        btnRegionPeoplePlus.setOnClickListener(this);
        btnSort=(Button)findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);

        etFunction=(EditText)findViewById(R.id.etFunction);
        etNaselennya=(EditText)findViewById(R.id.etNAselennya);
        etRegionPlus=(EditText)findViewById(R.id.etRegionNasPlus);

        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        dbHelperCountry = new DBHelperCountry(this);






    }

    public void creatDB(){

        // подключаемся к базе
        db = dbHelperCountry.getWritableDatabase();



        ContentValues cv=new ContentValues();
        for(int i=0;i<name.length;i++){
            cv.put(DBHelperCountry.KEY_NAME,name[i]);
            cv.put(DBHelperCountry.KEY_PEOPLE,people[i]);
            cv.put(DBHelperCountry.KEY_REGION,region[i]);
            db.insert(DBHelperCountry.TABLE_COUNTRY,null,cv);


            Log.d(LOG_TAG,cv.toString());

        }

        dbHelperCountry.close();

    }


    @Override
    public void onClick(View v) {
// подключаемся к базе
        db=dbHelperCountry.getWritableDatabase();
// данные с экрана
        String function=etFunction.getText().toString();
        String naselennya=etNaselennya.getText().toString();
        String regionPlus=etRegionPlus.getText().toString();

        // переменные для query
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy =  null;
        String having = null;
        String orderBy = null;

        // курсор

        Cursor c = null;
        switch (v.getId()){
            case R.id.btnAll:
                creatDB();
                break;

            case R.id.btnFunctions:

                columns = new String[] { function };
                c = db.query(DBHelperCountry.TABLE_COUNTRY, columns, null, null, null, null, null);

                break;
            case R.id.btnPeople:
                selection = "people > ?";
                selectionArgs = new String[] { naselennya };
                c = db.query("mytable", null, selection, selectionArgs, null, null,
                        null);
                break;

        }
        dbHelperCountry.close();

    }
}
