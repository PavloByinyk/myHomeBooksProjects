package com.bignerdranch.android.gsontrying;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by 1 on 06.07.2016.
 */
public interface AirportService {


    @GET("/places/coords_to_places_ru.json")
    Call<List<Airport>> airports(@Query("coords") String gps);
}
