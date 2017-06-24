package com.turtledev.pockercounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 1 on 17.04.2016.
 */
public class LoginActivity extends AppCompatActivity {

    private Button logBtn;
    private EditText etLog;
    private EditText etPas;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etLog=(EditText)findViewById(R.id.etLog);
        etPas=(EditText)findViewById(R.id.etPas);
        logBtn=(Button)findViewById(R.id.logBtn);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLog.length()==0 || etPas.length()==0){
                    Toast.makeText(LoginActivity.this, R.string.LogToast,Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
