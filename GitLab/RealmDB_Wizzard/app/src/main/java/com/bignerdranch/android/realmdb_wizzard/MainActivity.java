package com.bignerdranch.android.realmdb_wizzard;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bignerdranch.android.realmdb_wizzard.m_Realm.RealmHelper;
import com.bignerdranch.android.realmdb_wizzard.m_Realm.Spacecraft;
import com.bignerdranch.android.realmdb_wizzard.m_UI.MyAdapter;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    ArrayList<String> list;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    EditText editText;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.dialogButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInputDialog();
            }
        });

        //setup RV
        recyclerView= (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //REALM CONFIGURATION
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(realmConfiguration);


        //RETRIEVE
        RealmHelper realmHelper = new RealmHelper(realm);
        list = realmHelper.retrive();

        myAdapter=new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

    }



    private void displayInputDialog(){

        Dialog dialog=new Dialog(this);
        dialog.setTitle("save to DB");
        dialog.setContentView(R.layout.input_dialog);

        editText= (EditText) dialog.findViewById(R.id.nameEditText);
        Button saveButton= (Button) dialog.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SAVE
                Spacecraft spacecraft=new Spacecraft();
                spacecraft.setName(editText.getText().toString());

                RealmHelper realmHelper=new RealmHelper(realm);
                realmHelper.saveData(spacecraft);
//list.clear();
                list=realmHelper.retrive();
                myAdapter=new MyAdapter(MainActivity.this,list);
                recyclerView.setAdapter(myAdapter);


            }
        });

        dialog.show();

    }
}
