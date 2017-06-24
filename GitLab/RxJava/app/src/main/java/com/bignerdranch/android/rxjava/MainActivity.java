package com.bignerdranch.android.rxjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //myObservable.subscribe(mySubscriber);

        myObservable.subscribe(onNextAction);

        //Schedulers.io();



        Observable.just("Hello, world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));


        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .subscribe(s -> System.out.println(s));

        Observable.just("Hello, world!")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .subscribe(i -> System.out.println(Integer.toString(i)));

        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));

    }


    Observable<String> myObservable1 = Observable.create(
            new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> sub) {

                    sub.onNext("Hello, world!");
                    sub.onCompleted();
                }
            }
    );

    Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) { System.out.println(s); }

        @Override
        public void onCompleted() { }

        @Override
        public void onError(Throwable e) { }
    };


    Observable<String> myObservable = Observable.just("Hello, world!");

    Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println(s);
        }
    };









}
