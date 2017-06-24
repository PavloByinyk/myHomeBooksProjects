package com.bignerdranch.android.rxandretrofit.netWork;

import com.bignerdranch.android.rxandretrofit.pojo.WeatherData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 1 on 04.10.2016.
 */

public interface WeatherSerwice {

    String BASE_URL1="https://query.yahooapis.com/v1/public/";

    @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"london%2C%20uk\")%20and%20u%3D%27c%27&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    Observable<WeatherData> getWeatherData();
}
