package com.bignerdranch.android.gsontrying;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<Airport>> {

    String str="string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AirportService service = ApiFactory.getAirportsService();
        Call<List<Airport>> call = service.airports("55.749792,37.6324949");
        call.enqueue(this);

//        Gson gson=new GsonBuilder().create();
//
//        String stringTest1=gson.toJson(str);
//        String stringTest2=gson.toJson(new Person(24,"Roma"));
//
//        System.out.println("to Gson");
//        System.out.println("stringTest1\n"+stringTest1);
//        System.out.println("stringTest2\n"+stringTest2);
//
//
//
//        String stringTest3=gson.fromJson(stringTest1,String.class);
//        Person person=gson.fromJson(stringTest2,Person.class);
//
//        System.out.println("from Gson");
//        System.out.println("stringTest3\n"+stringTest3);
//        System.out.println("person\n"+person);

    }

    @Override
    public void onResponse(Response<List<Airport>> response) {
        if (response.isSuccess()) {
            List<Airport> airports = response.body();
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
