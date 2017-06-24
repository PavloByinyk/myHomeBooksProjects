package com.bignerdranch.android.shablonyprogramirovaniya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 1 on 28.08.2016.
 */
public class Builder extends AppCompatActivity {

    public static final String LOG="myLog";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);


        Director director=new Director(new FordBuilder());

        Car car=director.buildCar();

        Log.d(LOG,car.toString());



    }




    class Car {
        String name;
        String marka;
        int speed;

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setMarka(String marka) {
            this.marka = marka;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", marka='" + marka + '\'' +
                    ", speed=" + speed +
                    '}';
        }
    }

    abstract class CarBuilder {

        Car car;

        void createCar(){
            car=new Car();
        }
        abstract void buildName();
        abstract void buildMarka();
        abstract void buildSpeed();

        Car getCar(){
            return car;
        }
    }

    class FordBuilder extends CarBuilder{

        @Override
        void buildName() { car.setName("Ford");}

        @Override
        void buildMarka() {car.setMarka("GTR 110");}

        @Override
        void buildSpeed() {car.setSpeed(430);}
    }

    class BmwBuilder extends CarBuilder{

        @Override
        void buildName() {car.setName("BMW");}

        @Override
        void buildMarka() {car.setMarka("Pandora 20");}

        @Override
        void buildSpeed() {car.setSpeed(320);}
    }

    class Director{
        CarBuilder builder;

        public Director(CarBuilder builder) {
            this.builder = builder;
        }

        Car buildCar(){
            builder.createCar();
            builder.buildMarka();
            builder.buildName();
            builder.buildSpeed();
            return builder.getCar();

        }
    }



}
