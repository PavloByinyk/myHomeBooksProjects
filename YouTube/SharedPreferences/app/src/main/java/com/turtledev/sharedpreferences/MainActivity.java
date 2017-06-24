package com.turtledev.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSave,btnLoad,btnClear;
    EditText editText;
    SharedPreferences sharedPreferences;

    final String SAVE_TEXT="save_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        editText=(EditText)findViewById(R.id.editText);

        btnSave=(Button)findViewById(R.id.btnSave);
        btnClear=(Button)findViewById(R.id.btnClear);
        btnLoad=(Button)findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            case R.id.btnClear:
                clearText();
            default:
                break;
        }

    }

    private void clearText() {
        editText.setText("");
    }

    private void saveText() {
        sharedPreferences=getSharedPreferences("first name",MODE_PRIVATE);//задаэться ключ для значення
        SharedPreferences.Editor ed=sharedPreferences.edit();
        ed.putString(SAVE_TEXT,editText.getText().toString());
        ed.commit();
    }

    private void loadText() {
        sharedPreferences=getPreferences(MODE_PRIVATE);
        String text=sharedPreferences.getString(SAVE_TEXT,"");
        editText.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
