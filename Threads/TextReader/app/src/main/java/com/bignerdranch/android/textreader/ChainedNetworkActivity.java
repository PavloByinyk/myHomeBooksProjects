package com.bignerdranch.android.textreader;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 1 on 15.08.2016.
 */
public class ChainedNetworkActivity extends AppCompatActivity {


    private static final int DIALOG_LOADING = 0;
    private static final int SHOW_LOADING = 1;
    private static final int DISMISS_LOADING = 2;


    Handler dialogHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SHOW_LOADING:
                    showDialog(DIALOG_LOADING);
                    break;
                case DISMISS_LOADING:
                    dismissDialog(DIALOG_LOADING);
            }
        }
    };

    private NetworkHandlerThread mThread;

    public void onCreate( Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        mThread = new NetworkHandlerThread();
        mThread.start();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch ( id ) {
            case DIALOG_LOADING:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Loading ... ");
                dialog = builder.create();
                break;
        }
            return dialog;

        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mThread.quit();
    }






    private class NetworkHandlerThread extends HandlerThread {

        private static final int SТАТЕ_А = 1;
        private static final int SТАТЕ_B = 2;

        private Handler mHandler;

        public NetworkHandlerThread() {
            super("NetworkHandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
        }


        @Override
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            mHandler = new Handler(getLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);

                    switch (msg.what) {
                        case SТАТЕ_А:
                            dialogHandler.sendEmptyMessage(SHOW_LOADING);
                            String result = networkOperationl();
                            if (result != null) {
                                sendMessage(obtainMessage(SТАТЕ_B, result));
                            } else {
                                dialogHandler.sendEmptyMessage(DISMISS_LOADING);
                                break;
                            }
                        case SТАТЕ_B:
                            network0peration2( ( String)msg.obj );
                            dialogHandler.sendEmptyMessage( DISMISS_LOADING );
                            break;


                    }
                }


            };
            fetchDataFromNetwork ();
        }


        private String networkOperationl() {
            SystemClock.sleep(5000); // Имитация сетевой операции
            return  "А string";
        }
        private void network0peration2( String data ) {
            // Передача данных в сеть, например с помощью HttpPost
            SystemClock.sleep(5000);
        }


        // Открытая (видимая извне) сетевая операция

        public void fetchDataFromNetwork() {
            mHandler.sendEmptyMessage(SТАТЕ_А);
        }
    }
}
