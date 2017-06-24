package com.turtledev.intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        textView=(TextView)findViewById(R.id.textView);

        Intent intent=getIntent();
        String s=intent.getStringExtra("key");

        textView.setText(s);
    }
}
