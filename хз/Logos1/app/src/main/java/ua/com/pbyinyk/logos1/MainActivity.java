package ua.com.pbyinyk.logos1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button mCheck;
    private Button mDelete;
    private EditText editLog;
    private EditText editPas;
    private EditText editMail;
    private Pattern pattern;
    private Matcher matcher;
    private CheckBox pas,mail,log;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailValidator();
        editLog = (EditText) findViewById(R.id.edit_log);
        editPas = (EditText) findViewById(R.id.editpassword);
        editMail = (EditText) findViewById(R.id.editmail);
        pas = (CheckBox) findViewById(R.id.checkBoxPasword);
        mail =(CheckBox) findViewById(R.id.checkBoxMail);
        log = (CheckBox) findViewById(R.id.checkBoxLogin);




        mCheck = (Button) findViewById(R.id.check);
        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     if (editLog.length() == 0 || editMail.length() == 0 || editPas.length() == 0) {
                    Toast.makeText(MainActivity.this, "Заповніть усі поля", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Дані прийнято", Toast.LENGTH_SHORT).show();

                }*/
                pas.setChecked(false);
                mail.setChecked(false);
                log.setChecked(false);

                if (editLog.length() != 0){
                    log.setChecked(true);
                }

                if (editPas.length() != 0){
                    pas.setChecked(true);
                }

                if(validate(editMail.getText().toString())){
                    mail.setChecked(true);
                }


                if(log.isChecked() && mail.isChecked()&& pas.isChecked()){
                    Toast.makeText(MainActivity.this, "Дані прийнято", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mDelete = (Button) findViewById(R.id.delete);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editLog.setText("");
                editPas.setText("");
                editMail.setText("");
                pas.setChecked(false);
                mail.setChecked(false);
                log.setChecked(false);
            }
        });
    }
    public void EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }


//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);




    }

