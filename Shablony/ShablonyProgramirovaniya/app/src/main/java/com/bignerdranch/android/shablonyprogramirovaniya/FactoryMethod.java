package com.bignerdranch.android.shablonyprogramirovaniya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class FactoryMethod extends AppCompatActivity {

    public static final String myLog="myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);



        WatchMaker maker=new ElectronicWatchCreator();

        Watch watch=maker.createWatch();
        watch.showTime();
    }


    interface Watch{

         void showTime();
      }

    class DigitelWatch implements Watch{

        @Override
        public void showTime() {
            Log.d("DigitalWatch ",myLog);
        }
    }

    class ElectronicWatch implements Watch{

        @Override
        public void showTime() {
            Log.d("ElectronicWatch ",myLog);
        }
    }


    interface WatchMaker{
        Watch createWatch();
    }

    class DigitelWatchCreator implements WatchMaker{

        @Override
        public Watch createWatch() {
            return new DigitelWatch();
        }
    }

    class ElectronicWatchCreator implements WatchMaker{

        @Override
        public Watch createWatch() {
            return new ElectronicWatch();
        }
    }


}
