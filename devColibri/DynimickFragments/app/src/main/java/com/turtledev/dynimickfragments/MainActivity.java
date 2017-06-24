package com.turtledev.dynimickfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.turtledev.dynimickfragments.fragments.OneFragment;
import com.turtledev.dynimickfragments.fragments.TwoFragment;

/**
 * Created by 1 on 20.04.2016.
 */
public class MainActivity extends FragmentActivity {

    final static String TAG_1 = "FRAGMENT_1";
    final static String TAG_2 = "FRAGMENT_2";

    public OneFragment oneFragment;
    private TwoFragment twoFragment;

    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        manager=getSupportFragmentManager();

        oneFragment=new OneFragment();
        twoFragment=new TwoFragment();
    }
    public  void onClickFragment(View view){
        transaction=manager.beginTransaction();

        switch (view.getId()){
            case R.id.btnAdd:

                transaction.add(R.id.contaner,oneFragment);
                break;

        }


        transaction.commit();

    }

}
