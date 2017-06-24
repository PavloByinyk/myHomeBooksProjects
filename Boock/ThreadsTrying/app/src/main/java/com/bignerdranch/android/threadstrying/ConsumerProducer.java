package com.bignerdranch.android.threadstrying;

import android.util.Log;

import java.util.LinkedList;

/**
 * Created by 1 on 06.08.2016.
 */
public class ConsumerProducer {

    private static final String TAG ="mytag" ;
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;

    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    Log.d(TAG,"in produce  lock.wait();");
                    lock.wait();

                }
                Log.d(TAG,"in produce  list.add(value++);");
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {


        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    Log.d(TAG,"in consume  lock.wait();");
                    lock.wait();
                }
                Log.d(TAG,"in consume  list.removeFirst()");
                int value = list.removeFirst();
                lock.notify();
            }
        }
    }
}