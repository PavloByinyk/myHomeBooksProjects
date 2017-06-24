package com.bignerdranch.android.retrofitgsondemo.controller;

import com.bignerdranch.android.retrofitgsondemo.model.callback.FlowerService;
import com.bignerdranch.android.retrofitgsondemo.model.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 1 on 23.06.2016.
 */
public class RestManager {

     private FlowerService mFlowerService;

    public FlowerService getmFlowerService(){
        if ((mFlowerService == null)){

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerService=retrofit.create(FlowerService.class);
        }
        return mFlowerService;

    }


}
