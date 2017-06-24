package com.turtledev.requestresultcode;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int REQUEST_CODE_COLOR=1;
    final int REQUEST_CODE_ALIGN=2;

    TextView textView;
    Button btnColor,btnAligment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        btnAligment=(Button)findViewById(R.id.btn_aligment);
        btnColor=(Button)findViewById(R.id.btn_color);

        btnColor.setOnClickListener(this);
        btnAligment.setOnClickListener(this);
    }


    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_color:
                intent=new Intent(this,ColorActivity.class);
                startActivityForResult(intent,REQUEST_CODE_COLOR);
                break;
            case R.id.btn_aligment:
                intent=new Intent(this,AlignActivity.class);
                startActivityForResult(intent,REQUEST_CODE_ALIGN);
                break;
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            switch (requestCode){
                case REQUEST_CODE_COLOR:
                    int color=data.getIntExtra("color", Color.WHITE);
                    textView.setTextColor(color);
                    break;
                case REQUEST_CODE_ALIGN:
                    int align=data.getIntExtra("Align", Gravity.LEFT);
                    textView.setGravity(align);
                    break;
            }
        }else{
            Toast.makeText(this,"Nothing changed",Toast.LENGTH_SHORT).show();
        }
    }
}
