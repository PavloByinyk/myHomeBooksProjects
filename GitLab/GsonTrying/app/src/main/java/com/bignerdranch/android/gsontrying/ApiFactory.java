package com.bignerdranch.android.gsontrying;

import android.support.annotation.NonNull;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by 1 on 06.07.2016.
 */
public class ApiFactory {

    private static final int CONNECT_TIMEOUT = 15;
    private static final int WRITE_TIMEOUT = 60;
    private static final int TIMEOUT = 60;

    private static final OkHttpClient CLIENT = new OkHttpClient();


    static {
        CLIENT.setConnectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setWriteTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);
    }

    @NonNull
    public static AirportService getAirportsService() {
        return getRetrofit().create(AirportService.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://nano.aviasales.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(CLIENT)
                .build();
    }
}
