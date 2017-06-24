package com.turtledev.returnresultfromactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonOk;
    EditText textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName=(EditText) findViewById(R.id.editText);

        buttonOk=(Button)findViewById(R.id.button_OK);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent();
        intent.putExtra("key",textViewName.getText().toString());
        setResult(RESULT_OK,intent);
        finish();

    }
}
