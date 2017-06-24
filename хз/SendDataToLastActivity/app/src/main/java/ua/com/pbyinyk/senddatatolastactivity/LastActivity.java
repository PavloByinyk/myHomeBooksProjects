package ua.com.pbyinyk.senddatatolastactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class LastActivity extends Activity {

    private EditText txtLogin;
    private EditText txtPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);

        txtLogin=(EditText)findViewById(R.id.txtLogin);
        txtPassword=(EditText)findViewById(R.id.txtPassword);

        txtLogin.setText(getIntent().getStringExtra("editLogin"));
        txtPassword.setText(getIntent().getStringExtra("editPassword"));

    }

    public  void back(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
