package ua.com.pbyinyk.onactivityresultrequestcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 1 on 05.04.2016.
 */
public class PresentedActivity extends Activity {

    private EditText etName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presented_layout);

        etName=(EditText)findViewById(R.id.etName);

    }

    public  void onClick(View v){
        Intent intent=new Intent();
        intent.putExtra("name",etName.getText().toString());
        setResult(RESULT_OK,intent);
        finish();

    }
}
