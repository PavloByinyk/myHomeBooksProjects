package com.bignerdranch.android.photogallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 1 on 20.07.2016.
 */
public class StartupReceiver extends BroadcastReceiver {

    private static final String TAG = "StartupReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Received broadcast intent: " + intent.getAction());

    }
}
