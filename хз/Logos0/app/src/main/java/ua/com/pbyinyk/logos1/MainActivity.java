package ua.com.pbyinyk.logos1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mCheck;
    private Button mDelete;
    private EditText editLog;
    private EditText editPas;
    private EditText editMail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLog=(EditText)findViewById(R.id.edit_log);
        editPas=(EditText)findViewById(R.id.editpassword);
        editMail=(EditText)findViewById(R.id.editmail);



        mCheck=(Button)findViewById(R.id.check);
        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editLog.length()==0 || editMail.length()==0 || editPas.length()==0){
                    Toast.makeText(MainActivity.this,"Заповніть усі поля",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Дані прийнято",Toast.LENGTH_SHORT).show();

                }


            }
        });
        mDelete=(Button)findViewById(R.id.delete);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editLog.setText("");
                editPas.setText("");
                editMail.setText("");
            }
        });
    }
}
