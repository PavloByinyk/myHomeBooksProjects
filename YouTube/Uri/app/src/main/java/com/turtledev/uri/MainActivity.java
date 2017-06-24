package com.turtledev.uri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonMap,buttonCall,buttonWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCall=(Button)findViewById(R.id.buttonCall);
        buttonMap=(Button)findViewById(R.id.buttonMap);
        buttonWeb=(Button)findViewById(R.id.buttonWeb);
        buttonMap.setOnClickListener(this);
        buttonCall.setOnClickListener(this);
        buttonWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.buttonCall:
                intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345"));
                startActivity(intent);
                break;

            case R.id.buttonMap:
                intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: 0,0"));
                startActivity(intent);
                break;
            case R.id.buttonWeb:
                intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(intent);
                break;
        }

    }
}
