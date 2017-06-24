package com.bignerdranch.android.retrofit_weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.android.retrofit_weather.data.Model.Query;
import com.bignerdranch.android.retrofit_weather.data.Model.Weather;
import com.bignerdranch.android.retrofit_weather.data.Model.netWork.WeatherAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView a,b,c,d,i,f;
    Button z,x;
    MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=(TextView)findViewById(R.id.textView);
        b=(TextView)findViewById(R.id.textView2);
        c=(TextView)findViewById(R.id.textView3);
        d=(TextView)findViewById(R.id.textView4);
        z=(Button) findViewById(R.id.button);
        x=(Button) findViewById(R.id.button2);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, NewActivite.class);
                startActivity(intent);
            }
        });

        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WeatherAPI.Factory.getInctance(mContext).getWeather().enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {

                        Query query=response.body().getQuery();
                        a.setText(query.getResults().getChannel().getItem().getCondition().getTemp());
                        b.setText(query.getResults().getChannel().getLocation().getCity());
                        c.setText(query.getResults().getChannel().getLanguage());
                        d.setText(query.getResults().getChannel().getLastBuildDate());

                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {

                    }
                });

            }
        });



    }
}
