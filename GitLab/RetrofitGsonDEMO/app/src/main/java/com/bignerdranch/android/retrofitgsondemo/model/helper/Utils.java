package com.bignerdranch.android.retrofitgsondemo.model.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;

/**
 * Created by 1 on 23.06.2016.
 */
public class Utils {

    public static boolean isNetworkAvaliable(Context context){

        final ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();

    }

    public static byte[] getPicturesByteOfArray(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    public static Bitmap getBitmapFromByte(byte[] image){
        return BitmapFactory.decodeByteArray(image ,0 ,image.length);
    }
}
