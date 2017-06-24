package com.bignerdranch.android.textreader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.LinkedList;

/**
 * Created by 1 on 23.11.2016.
 */

public class ConsumerProducer extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final PojoConsumerProducer consumerProducer = new PojoConsumerProducer();
        Thread tl = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumerProducer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumerProducer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tl.start();
        t2.start();
    }


    class PojoConsumerProducer{
        private LinkedList<Integer> list = new LinkedList<Integer>();
        private final int LIMIT = 10;
        private Object lock = new Object();

        public void produce() throws InterruptedException {
        int value = 0;
        while( true ) {
            synchronized ( lock ) {
                while( list.size() == LIMIT ) {
                    value = 0;
                    lock.wait();
                }
        list.add( value++ );
                Log.d("consumerLog" ," add " + value);
        lock. notify ();
    }
}
        }

        public void consume() throws InterruptedException {
            while ( true ) {
                synchronized( lock) {
                    while( list.size() ==0 ) {
                    lock.wait();
                }
            int value = list.removeFirst();
                    Log.d("consumerLog" ," remove " + value);
            lock.notify();

    }
        }
        }
    }}
