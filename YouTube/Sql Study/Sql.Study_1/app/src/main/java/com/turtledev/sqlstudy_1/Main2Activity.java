package com.turtledev.sqlstudy_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    public static final String DEFOULT="N/A";

    EditText editTextq,editText2q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText2q=(EditText)findViewById(R.id.editText2q);
        editTextq=(EditText)findViewById(R.id.editTextq);

    }

    public void load(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("name",DEFOULT);
        String password=sharedPreferences.getString("password",DEFOULT);

        if(name.equals(DEFOULT)|| name.equals("") || password.equals(DEFOULT)||password.equals("")){
            Toast.makeText(this,DEFOULT,Toast.LENGTH_SHORT).show();

        }else{
            editText2q.setText(name);
            editTextq.setText(password.toString());


        }


    }

    public void previous(View v){
        Intent intent=new Intent(this,MainActivity.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
