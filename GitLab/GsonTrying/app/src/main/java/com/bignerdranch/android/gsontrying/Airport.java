package com.bignerdranch.android.gsontrying;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 1 on 06.07.2016.
 */
public class Airport {

    @SerializedName("iata")
    private String mIata;

    @SerializedName("name")
    private String mName;

    @SerializedName("airport_name")
    private String mAirportName;

    public Airport() {
    }
}
