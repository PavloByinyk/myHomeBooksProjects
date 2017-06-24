package com.bignerdranch.android.retrofit_weather;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bignerdranch.android.retrofit_weather.data.Model.ChargesDetail;
import com.bignerdranch.android.retrofit_weather.data.Model.netWork.WeatherAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 1 on 19.07.2016.
 */
public class NewActivite  extends AppCompatActivity{

    Button getAll,getOne,delete,post;
    EditText getname,postName,postSum;
    TextView textView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);
        mContext=this;

        getAll=(Button) findViewById(R.id.button3);
        getAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               WeatherAPI weatherAPI= WeatherAPI.Factory.getInctance(mContext);

                weatherAPI.getCharges().enqueue(new Callback<List<ChargesDetail>>() {
                    @Override
                    public void onResponse(Call<List<ChargesDetail>> call, Response<List<ChargesDetail>> response) {
                        if(response.isSuccessful()){

                            List<ChargesDetail> list=response.body();
                            textView.setText(list.toString());
                        }else{
                            Log.d("myLog1",response.code()+"myLog1");
                        }

                    }

                    @Override
                    public void onFailure(Call<List<ChargesDetail>> call, Throwable t) {


                        Log.d("myLog","myLog");

                    }
                });
            }
        });





        getOne=(Button) findViewById(R.id.button4);
        delete=(Button) findViewById(R.id.button5);
        post=(Button) findViewById(R.id.button6);



        getname= (EditText) findViewById(R.id.editText);
        postName= (EditText) findViewById(R.id.editText2);
        postSum= (EditText) findViewById(R.id.editText2);


        textView= (TextView) findViewById(R.id.textView5);


    }
}
