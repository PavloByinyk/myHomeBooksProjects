package com.bignerdranch.android.shablonyprogramirovaniya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 02.09.2016.
 */
public class ObserverClass extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);

        MeteoStation meteoStation=new MeteoStation();
        meteoStation.addObserver(new massageObserv());

        meteoStation.setData(45,23);


    }

    interface Observer{
        void handlerEvent(int temperatura,int pressure);

    }

    interface Observed{
        void addObserver(Observer o);
        void deleteObserver(Observer o);
        void notifyObserver();
    }

    class MeteoStation implements Observed{
        int temperatura;
        int pressure;

        List<Observer> list =new ArrayList<>();



        void setData(int t,int p){
            temperatura=t;
            pressure=p;
            notifyObserver();
        }
        @Override
        public void addObserver(Observer o) {
            list.add(o);

        }

        @Override
        public void deleteObserver(Observer o) {
            list.remove(o);

        }

        @Override
        public void notifyObserver() {

            for(Observer o : list){
                o.handlerEvent(temperatura,pressure);
            }

        }


    }

    class massageObserv implements Observer{

        @Override
        public void handlerEvent(int temperatura, int pressure) {
            System.out.print("temperatura is "+ temperatura + "pressure is" +pressure );
        }
    }
}
