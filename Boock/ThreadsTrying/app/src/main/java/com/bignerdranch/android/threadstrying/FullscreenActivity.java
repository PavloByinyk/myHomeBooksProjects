package com.bignerdranch.android.threadstrying;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity  implements MyWorkerThread.Callback{

    private static boolean isVisible;
    public static final int LEFT_SIDE = 0;
    public static final int RIGHT_SIDE = 1;
    private LinearLayout mLeftSideLayout;
    private LinearLayout mRightSideLayout;
    private MyWorkerThread mWorkerThread;

    private static final String TAG="mytag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        isVisible = true;
        mLeftSideLayout = (LinearLayout) findViewById(R.id.leftSideLayout);
        mRightSideLayout = (LinearLayout) findViewById(R.id.rightSideLayout);
        String[] urls = new String[]{"http://developer.android.com/design/media/principles_delight.png",
                "http://developer.android.com/design/media/principles_real_objects.png",
                "http://developer.android.com/design/media/principles_make_it_mine.png",
                "http://developer.android.com/design/media/principles_get_to_know_me.png"};
        mWorkerThread = new MyWorkerThread(new Handler(), this);
        mWorkerThread.start();
        mWorkerThread.prepareHandler();
        Random random = new Random();
        for (String url : urls){
            mWorkerThread.queueTask(url, random.nextInt(2), new ImageView(this));
        }



        final ConsumerProducer cp = new ConsumerProducer ();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG,"in cp.produce();");
                    cp.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG,"in cp.consume();");
                    cp.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();







    }




    @Override
    protected void onPause() {
        isVisible = false;
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWorkerThread.quit();
        super.onDestroy();
    }

    @Override
    public void onImageDownloaded(ImageView imageView, Bitmap bitmap, int side) {
        imageView.setImageBitmap(bitmap);
        if (isVisible && side == LEFT_SIDE){
            mLeftSideLayout.addView(imageView);
        } else if (isVisible && side == RIGHT_SIDE){
            mRightSideLayout.addView(imageView);
        }
    }
}
