package com.turtledev.easybrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAdress=(EditText)findViewById(R.id.editAdress);


        (findViewById(R.id.buttonWeb)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+textAdress.getText().toString()));
                //intent.putExtra("adress",textAdress.getText().toString());
                startActivity(intent);



            }
        });
    }
}
