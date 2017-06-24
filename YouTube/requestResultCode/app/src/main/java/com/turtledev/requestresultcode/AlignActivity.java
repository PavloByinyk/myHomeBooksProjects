package com.turtledev.requestresultcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLeft,btnRigth,btnCentr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnCentr=(Button)findViewById(R.id.btn_center);
        btnRigth=(Button)findViewById(R.id.btn_rigth);
        btnLeft=(Button)findViewById(R.id.btnLeft);

        btnCentr.setOnClickListener(this);
        btnRigth.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();

        switch (v.getId()){
            case R.id.btnLeft:
                intent.putExtra("Align", Gravity.LEFT);
                break;
            case R.id.btn_rigth:
                intent.putExtra("Align", Gravity.RIGHT);
                break;
            case R.id.btn_center:
                intent.putExtra("Align", Gravity.CENTER);
                break;
        }
        setResult(RESULT_OK,intent);
        finish();

    }
}
