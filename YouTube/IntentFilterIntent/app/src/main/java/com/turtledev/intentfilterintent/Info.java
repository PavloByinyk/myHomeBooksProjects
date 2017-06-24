package com.turtledev.intentfilterintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent=getIntent();
        String action=intent.getAction();

        String format="", textInfo="";

        if(action.equals("info.fanandroid.intent.action.time")){
            format="hh:mm:ss";
            textInfo="Time: ";
        }else
            if(action.equals("info.fanandroid.intent.action.date")){
            format="yyyy-MM-dd";
            textInfo="Date: ";
        }

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        String dateTime=simpleDateFormat.format(new Date(System.currentTimeMillis()));

        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(textInfo + format);
    }
}
