package com.bignerdranch.android.retrofit_weather.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by 1 on 19.07.2016.
 */
public class ChargesDetail implements Parcelable {
    @SerializedName(value = "chargeName")
    private String parentChargeNAme;

    @SerializedName(value = "objectId")
    private String objectId;

    private String description;
    private double sum;
    public void setTime(Date time) {
        this.time = time;
    }

    private Date time;

    public ChargesDetail() {
    }

    public ChargesDetail(String parentChargeNAme, String description, double sum) {
        this.parentChargeNAme = parentChargeNAme;
        this.description = description;
        time = new Date();
        this.sum = sum;
    }

    public Date getTime() {
        return time;
    }

    protected ChargesDetail(Parcel in) {
        parentChargeNAme = in.readString();
        objectId = in.readString();
        description = in.readString();
        sum = in.readDouble();
    }

    public static final Creator<ChargesDetail> CREATOR = new Creator<ChargesDetail>() {
        @Override
        public ChargesDetail createFromParcel(Parcel in) {
            return new ChargesDetail(in);
        }

        @Override
        public ChargesDetail[] newArray(int size) {
            return new ChargesDetail[size];
        }
    };

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectID() {
        return objectId;
    }

    public void setObjectID(String objectID) {
        this.objectId = objectID;
    }

    public String getParentChargeNAme() {
        return parentChargeNAme;
    }

    public void setParentChargeNAme(String parentChargeNAme) {
        this.parentChargeNAme = parentChargeNAme;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(parentChargeNAme);
        dest.writeString(objectId);
        dest.writeString(description);
        dest.writeDouble(sum);
    }

    @Override
    public String toString() {
        return "ChargesDetail{" +
                "parentChargeNAme='" + parentChargeNAme + '\'' +
                ", objectId='" + objectId + '\'' +
                ", description='" + description + '\'' +
                ", sum=" + sum +
                ", time=" + time +
                '}';
    }
}