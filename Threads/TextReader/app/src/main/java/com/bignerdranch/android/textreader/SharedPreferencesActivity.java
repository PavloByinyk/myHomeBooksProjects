package com.bignerdranch.android.textreader;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 1 on 15.08.2016.
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    TextView textView;

    private Handler mUiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                Integer i = (Integer) msg.obj;
                textView.setText(Integer.toString(i));
            }
        }
    };


    private int mCount;


    private SharedPreferenceThread mThread;
    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);

        setContentView(R.layout.activity_main3);
        textView = (TextView) findViewById(R.id.text_view);
        mThread = new SharedPreferenceThread();
        mThread.start();
    }


    //Зались лустого значения из UI-лотока

    public void onButtonClickWrite(View v) {
        mThread.write(mCount++);
    }

    //Инициализация чтения из UI-потока

    public void onButtonClickRead(View v) {
        mThread.read();
    }

    //Необходимо обеслечить завершение фонового лотока

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mThread.quit ();
    }


    //одновременно с завершением комлонента Activity
    private class SharedPreferenceThread extends HandlerThread {

        private static final String KEY = "key";
        private SharedPreferences mPrefs;
        private static final int READ = 1;
        private static final int WRITE = 2;

        private Handler mHandler;


        public SharedPreferenceThread() {
            super("SharedPreferenceThread", Process.THREAD_PRIORITY_BACKGROUND);
            mPrefs = getSharedPreferences("LocalPrefs", MODE_PRIVATE);
        }


        @Override
        protected void onLooperPrepared() {
            super.onLooperPrepared();

            mHandler = new Handler(getLooper()) {
                @Override

                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case READ:
                            mUiHandler.sendMessage(mUiHandler.obtainMessage
                                    (0, mPrefs.getInt(KEY, 0)));
                            break;
                        case WRITE:
                            //mPrefs = getSharedPreferences("LocalPrefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = mPrefs.edit();
                            editor.putInt(KEY, (Integer) msg.obj);
                            editor.commit();
                            break;
                    }
                }


            };


        }

        public void read() {
            mHandler.sendEmptyMessage(READ);
        }

        public void write(int i) {
            mHandler.sendMessage(Message.obtain(mHandler,
                    WRITE, i));
        }

    }
}
