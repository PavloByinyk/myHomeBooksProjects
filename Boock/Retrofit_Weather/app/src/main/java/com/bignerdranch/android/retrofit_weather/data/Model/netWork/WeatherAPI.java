package com.bignerdranch.android.retrofit_weather.data.Model.netWork;

import android.content.Context;

import com.bignerdranch.android.retrofit_weather.data.Model.ChargesDetail;
import com.bignerdranch.android.retrofit_weather.data.Model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by 1 on 18.07.2016.
 */
public interface WeatherAPI {

     String BASE_URL1="https://query.yahooapis.com/v1/public/";
     String BASE_URL2="http://api.backendless.com/v1/";

    @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"london%2C%20uk\")%20and%20u%3D%27c%27&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    Call<Weather> getWeather();


    @Headers({"application-id: 9FB3F995-7D5A-D629-FF78-C5CE1E9DB000",
            "secret-key: 81BC7440-0B2E-F347-FF87-8ADC4FDE7B00",
            "application-type: REST",
            "Content-Type: application/json"})
    @GET("data/Charges")
    Call<List<ChargesDetail>> getCharges();

    class Factory{

        static WeatherAPI service;

        public static WeatherAPI getInctance(Context context){
            if(service== null){
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL1)
                        .build();
                service = retrofit.create(WeatherAPI.class);
                return service;
            }else {
                return service;
            }
        }

    }

}
