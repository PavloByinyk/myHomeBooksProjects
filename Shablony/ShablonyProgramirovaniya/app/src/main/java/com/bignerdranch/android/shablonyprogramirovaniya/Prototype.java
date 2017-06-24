package com.bignerdranch.android.shablonyprogramirovaniya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 1 on 28.08.2016.
 */
public class Prototype extends AppCompatActivity {

    public static final String LOG="myLog";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);

        Human original=new Human("Tolik",25);

        Log.d(LOG,original.toString());


        Human copy=  original.copy();
        Log.d(LOG,copy.toString());


        HumanFactory humanFactory=new HumanFactory(original);

//        Human h1=humanFactory.makeCopy();
//        Log.d(LOG,h1.toString());

        HumanFactory humanFactory1=new HumanFactory(new Human("Vasya",65));
        humanFactory1.makeCopy();
        Log.d(LOG,copy.toString());

    }


    interface Copyable{
        Object copy();
    }

    class Human implements Copyable{

        String name;

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        int age;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public Human copy() {
            return new Human(name,age);

        }
    }

    class HumanFactory{
        Human human;

        public HumanFactory(Human human) {
            this.human = human;
        }

        Human makeCopy(){

                return human.copy();

            }

    }

}
