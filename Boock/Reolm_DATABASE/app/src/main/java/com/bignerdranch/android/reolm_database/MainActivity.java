package com.bignerdranch.android.reolm_database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.reolm_database.model.Person;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    Button save,load;
    TextView log;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        name=(EditText)findViewById(R.id.et_Name);
        age=(EditText)findViewById(R.id.et_Age);
        save= (Button) findViewById(R.id.btn_Save);
        load= (Button) findViewById(R.id.btn_Load);
        log= (TextView) findViewById(R.id.tv_Log);


        
        save.setOnClickListener(v -> saveDataToDB(name.getText().toString(), Integer.parseInt(age.getText().toString())));
        load.setOnClickListener(v -> loadFromDB());
    }

    private void loadFromDB() {
        RealmResults<Person> result2 = realm.where(Person.class)
                .equalTo("name", "Viola")
                .findAll();

        String output="";
        for(Person person:result2){
            output+="\n"+person.getName().toString();
        }
        log.setText(output);

    }

    private void saveDataToDB(final String name, final int age) {
        realm.executeTransactionAsync(bgRealm -> {
            Person person = bgRealm.createObject(Person.class);
            person.setName(name);
            person.setAge(age);
        }, () -> {
            // Transaction was a success.
            Toast.makeText(getApplicationContext(),"Realm onSuccess",Toast.LENGTH_LONG).show();
            Log.d("database",">>>onSuccess<<<");
        }, error -> {
            // Transaction failed and was automatically canceled.
            Log.d("database",">>>onError<<<");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
