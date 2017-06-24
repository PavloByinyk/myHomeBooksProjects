package com.bignerdranch.android.locatr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class LocatrActivity extends SingleFragmentActivity {

    private static final int REQUEST_ERROR = 0;


    protected Fragment createFragment() {
        Log.d("MyLog","LocatrActivity");
        return LocatrFragment.newInstance();
    }


    @Override
    protected void onResume() {
        super.onResume();
        int errorCode = GooglePlayServicesUtil.
                isGooglePlayServicesAvailable(this);
        if (errorCode != ConnectionResult.SUCCESS) {
            Dialog errorDialog = GooglePlayServicesUtil
                    .getErrorDialog(errorCode, this, REQUEST_ERROR,
                            new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialog) {
// Выйти, если сервис недоступен
                                    finish();
                                }
                            });
            errorDialog.show();
        }
    }
}
