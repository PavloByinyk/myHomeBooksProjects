package com.turtledev.sqlstudy_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etLog,etPas;
    Button bSave,bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLog=(EditText)findViewById(R.id.editText);
        etPas=(EditText)findViewById(R.id.editText2);
        bSave=(Button)findViewById(R.id.button);


    }

    public void save(View v){

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",etLog.getText().toString());
        editor.putString("password",etPas.getText().toString());
        editor.commit();


    }

    public void setbNext(View v){
        Intent intent=new Intent(this,Main2Activity.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
