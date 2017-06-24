package com.bignerdranch.android.textreader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {


    private final static int SHOW_PROGRESS_BAR = 1;
    private final static int HIDE_PROGRESS_BAR = 0;
    private BackgroundThread mBackgroundThread;
    private TextView mText;
    private Button mButton;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mBackgroundThread = new BackgroundThread();
        mBackgroundThread.start();


        mText = (TextView)findViewById ( R. id. text ) ;
        mProgressBar = (ProgressBar)findViewById( R.id.progress );
        mButton = (Button)findViewById( R.id.button );

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBackgroundThread.doWork();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBackgroundThread.exit();
    }


    private final Handler mUiHandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_PROGRESS_BAR:
                    mProgressBar.setVisibility(View.VISIBLE);
                    break;
                case HIDE_PROGRESS_BAR:
                    mText.setText(String.valueOf(msg.arg1));
                    mProgressBar.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };

    public class BackgroundThread extends Thread{

        private Handler  mBackgroundHandler;

        public void run(){
            Looper.prepare();

            mBackgroundHandler=new Handler();

            Looper.loop();
        }

        public void doWork(){

            mBackgroundHandler.post(new Runnable() {
                @Override
                public void run() {
                    Message ums= mUiHandler.obtainMessage(SHOW_PROGRESS_BAR,0,0,null);
                    mUiHandler.sendMessage(ums);

                    Random r = new Random();
                    int randomlnt = r.nextInt(5000);
                    SystemClock.sleep(randomlnt);

                    ums = mUiHandler.obtainMessage( HIDE_PROGRESS_BAR,
                            randomlnt, 0, null ) ;
                    mUiHandler. sendMessage ( ums ) ;
                }
            });
        }

        public  void exit(){
            mBackgroundHandler.getLooper().quit();
        }
    }
}
