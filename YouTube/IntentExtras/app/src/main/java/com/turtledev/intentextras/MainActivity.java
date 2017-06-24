package com.turtledev.intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=(EditText)findViewById(R.id.editText);

        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ViewActivity.class);
        intent.putExtra("key",etName.getText().toString());
        startActivity(intent);
    }
}
