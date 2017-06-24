package com.bignerdranch.android.shablonyprogramirovaniya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 1 on 27.08.2016.
 */
public class AbstractFactoryMethod extends AppCompatActivity {

    public static final String LOG="myLog";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);

        DeviceFactory deviceFactory=getDeviceFactory("En");

        Mouse mouse=deviceFactory.getMouse();
        Touchpad touchpad=deviceFactory.getTouchpad();
        Keyboard keyboard=deviceFactory.getKeyboard();

        mouse.click();
        touchpad.track();
        keyboard.println();
    }

    private DeviceFactory getDeviceFactory(String name){
        switch (name){
            case "Ru" :
                return new RuDevicefactory();

            case "En" :
                return new EnDevicefactory();
        }
        return null;
    }

    interface Mouse{
        void click();
        void dbClick();
        void scroll(int direction);

    }
    interface Keyboard{
        void print();
        void println();

    }
    interface Touchpad{
        void track();
    }

    interface DeviceFactory{
        Mouse getMouse();
        Keyboard getKeyboard();
        Touchpad getTouchpad();

    }


    public class RuDevicefactory implements DeviceFactory{

        @Override
        public Mouse getMouse() {
            return new RuMouse();
        }

        @Override
        public Keyboard getKeyboard() {
            return new RuKeyboard();
        }

        @Override
        public Touchpad getTouchpad() {
            return new RuTouchpad();
        }
    }

    public class EnDevicefactory implements DeviceFactory{

        @Override
        public Mouse getMouse() {
            return new EnMouse();
        }

        @Override
        public Keyboard getKeyboard() {
            return new EnKeyboard();
        }

        @Override
        public Touchpad getTouchpad() {
            return new EnTouchpad();
        }
    }


    public class RuMouse implements Mouse{

        @Override
        public void click() {
            Log.d(LOG,"click Ru");
        }

        @Override
        public void dbClick() {
            Log.d(LOG,"DBclick Ru");
        }

        @Override
        public void scroll(int direction) {
            if(direction>0) {
                Log.d(LOG, "scroll Ru > 0");
            }else {
                Log.d(LOG,"scroll Ru < 0");
            }

        }
    }

    public class EnMouse implements Mouse{

        @Override
        public void click() {
            Log.d(LOG,"click En");
        }

        @Override
        public void dbClick() {
            Log.d(LOG,"DBclick En");
        }

        @Override
        public void scroll(int direction) {
            if(direction>0) {
                Log.d(LOG, "scroll En > 0");
            }else {
                Log.d(LOG,"scroll En < 0");
            }

        }
    }

    public class RuTouchpad implements Touchpad{

        @Override
        public void track() {
            Log.d(LOG,"RuTouchpad ");
        }
    }
    public class EnTouchpad implements Touchpad{

        @Override
        public void track() {
            Log.d(LOG,"EnTouchpad ");
        }
    }

    class RuKeyboard implements Keyboard{

        @Override
        public void print() {
            Log.d(LOG,"RuKeyboard print");
        }

        @Override
        public void println() {
            Log.d(LOG,"RuKeyboard println");
        }
    }
    class EnKeyboard implements Keyboard{

        @Override
        public void print() {
            Log.d(LOG,"EnKeyboard print");
        }

        @Override
        public void println() {
            Log.d(LOG,"EnKeyboard println");
        }
    }
}
