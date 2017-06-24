package com.bignerdranch.android.retrofitgsondemo.model.callback;

import com.bignerdranch.android.retrofitgsondemo.model.Flower;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;


/**
 * Created by 1 on 23.06.2016.
 */
public interface FlowerService {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
