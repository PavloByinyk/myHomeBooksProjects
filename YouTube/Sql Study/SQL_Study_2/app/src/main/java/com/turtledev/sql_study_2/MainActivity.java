package com.turtledev.sql_study_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.turtledev.sql_study_2.DBHelper.DBAdapter;
import com.turtledev.sql_study_2.pojo.Login;
import com.turtledev.sql_study_2.pojo.LoginAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBAdapter dbAdapter;
    EditText log, pas;
    Button button;
    ListView listView;
    LoginAdapter loginAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = (EditText) findViewById(R.id.etSetLog);
        pas = (EditText) findViewById(R.id.etSetPas);
        button = (Button) findViewById(R.id.SHOW_ALL);
        listView = (ListView) findViewById(R.id.listView);
        dbAdapter = new DBAdapter(this);


    }

    public void showAllData(View v) {
        ArrayList<Login> loginList = dbAdapter.getAllData();
        loginAdapter = new LoginAdapter(loginList, this);
        listView.setAdapter(loginAdapter);
    }


    public void addUser(View v) {
        String login = log.getText().toString();
        String password = pas.getText().toString();

        long id = dbAdapter.insertData(login, password);
        if (id < 0) {
            Massage.massage(this, "ERROR");
        } else {
            Massage.massage(this, "SUCCESS");
        }


    }
    public void showData(View v){
        String s=log.getText().toString();
        String s2=dbAdapter.getData(s);
        Massage.massage(this,s2);
    }

    public void showId(View v){
        String s=log.getText().toString();
        String sub1= s.substring(0,s.indexOf(" "));
        String sub2=s.substring(s.indexOf(" ")+1);

        String s2=dbAdapter.getId(sub1,sub2);
        Massage.massage(this,s2);
    }
    public void update(View v){
//        String s=log.getText().toString();
//        String s1=pas.getText().toString();
      dbAdapter.updateName("Pavlo","NApoleon");

    }
    public void delete(View v){
        String s=log.getText().toString();
       int count= dbAdapter.deleteRow(s);
        Massage.massage(this,""+count);


    }
}
