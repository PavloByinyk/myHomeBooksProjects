package com.turtledev.requestresultcode;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRed,btnGreen,btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnBlue=(Button)findViewById(R.id.btn_Blue);
        btnRed=(Button)findViewById(R.id.btn_Red);
        btnGreen=(Button)findViewById(R.id.btn_Green);
        btnGreen.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();

        switch (v.getId()){
            case R.id.btn_Red:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btn_Blue:
                intent.putExtra("color", Color.BLUE);
                break;
            case R.id.btn_Green:
                intent.putExtra("color", Color.GREEN);
                break;
        }
        setResult(RESULT_OK,intent);
        finish();

    }
}
