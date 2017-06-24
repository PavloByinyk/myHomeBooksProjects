package com.bignerdranch.android.rxjava;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.android.rxjava.mDataBase.MyDBHelper;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RxAndDataBase extends AppCompatActivity {

    String userId="2";
    TextView listView;
    Button button,button1;
    List<Charge> list;


    SQLiteDatabase sqLiteDatabase;
    private List<Charge> users;
    private String TAG="myLog";

    MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_and_retrofit);

        listView= (TextView) findViewById(R.id.listView);
        button=(Button) findViewById(R.id.button);
        button1=(Button) findViewById(R.id.button1);

//        sqLiteDatabase = new DBHelper(this).getWritableDatabase();
//        dbHelper=new DBHelper(this);



        Log.e(TAG, "в onCreate" + Thread.currentThread().getName().toString());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaddb();
            }
        });











    }


//    public void load(View v){
//
//
//        MyDBHelper.getDbAdapter(this).getUsers1()
//
//                .map(new Func1<List<Charge>, String>() {
//
//                    @Override
//                    public String call(List<Charge> charges) {
//                        String name = null;
//                        for (Charge ch : charges) {
//
//                            if (ch.getId().equals("1888")) {
//                                name=ch.getName().toString();
//                            }
//                            }
//
//                        return name;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//
//
//                    @Override
//                    public void call(String s) {
//                        listView.setText(s);
//                    }
//
//
//    });
//    }

    public void loaddb(){

       MyDBHelper.getDbAdapter(this).loadTodb(createList());
}

    public void load2(View v){
        MyDBHelper.makeObservable(MyDBHelper.getDbAdapter(this)
                .getUsers())
                .subscribeOn(Schedulers.io())
                .map(new Func1<List<Charge>, String>() {

            @Override
            public String call(List<Charge> charges) {
                String name = null;
                for (Charge ch : charges) {

                    if (ch.getId().equals("1888")) {
                        name=ch.getName().toString();
                    }
                }

                return name;
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {


                    @Override
                    public void call(String s) {
                        listView.setText(s);
                    }


                });
    }














    public List<Charge> createList(){

        list=new ArrayList<>();

        int i=0;


        for(int a=0;a<2000;a++){

           Charge charge=new Charge();

            charge.setName("Vasya");

            charge.setId(Integer.toString(i++));
            list.add(charge);


        }
        return  list;
    }

}
