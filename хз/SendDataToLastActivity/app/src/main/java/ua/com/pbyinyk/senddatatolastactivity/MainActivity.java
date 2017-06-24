package ua.com.pbyinyk.senddatatolastactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 1 on 03.04.2016.
 */
public class MainActivity extends Activity {

    private EditText editLogin;
    private EditText editPassword;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        editLogin=(EditText)findViewById(R.id.editlogin);
        editPassword=(EditText)findViewById(R.id.editPassword);
    }

    public void sendData(View v){
        Intent intent=new Intent(this,LastActivity.class);
        intent.putExtra("editLogin",editLogin.getText().toString());
        intent.putExtra("editPassword",editPassword.getText().toString());
        startActivity(intent);
    }
}
