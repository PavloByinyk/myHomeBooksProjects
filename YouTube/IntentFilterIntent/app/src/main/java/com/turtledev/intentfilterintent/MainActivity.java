package com.turtledev.intentfilterintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btTime=(Button)findViewById(R.id.button_time);
        Button btDate=(Button)findViewById(R.id.button_date);

        btDate.setOnClickListener(this);
        btTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.button_time:
                intent=new Intent("info.fanandroid.intent.action.time");
                startActivity(intent);
                break;
            case R.id.button_date:
                intent=new Intent("info.fanandroid.intent.action.date");
                startActivity(intent);
                break;

        }

    }
}
