package com.bignerdranch.android.jsonprogrammingwizards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.bignerdranch.android.jsonprogrammingwizards.m_JSON.JSONDownloader;

public class MainActivity extends AppCompatActivity {

    String jsonURL="http://jsonplaceholder.typicode.com/users";
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=(Spinner) findViewById(R.id.m_spinner);



        new JSONDownloader(this,sp,jsonURL).execute();
    }
}
