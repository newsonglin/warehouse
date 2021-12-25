package com.lin.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/17/2021
 */
public class ConnectableObservable {

    public static void main(String[] args) throws Exception{
        Observable source=Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable=source.subscribe(s->System.out.println("Observer1 on Cold Observable==>"+s));
        Thread.sleep(10000);
        disposable.dispose(); //Stop observe

        System.out.println("Cold Observable, Observer2 will get all the things and from begin 0");
        disposable=source.subscribe(s->System.out.println("Observer2 on Cold Observable==>"+s));
        Thread.sleep(10000);
        disposable.dispose(); //Stop observe

        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).publish();
        connectableObservable.connect();
        disposable=connectableObservable.subscribe(s->System.out.println("Observer1 on Hot Observable==>"+s));
        Thread.sleep(10000);
        disposable.dispose(); //Stop observe

        System.out.println("Hot Observable, Observer2 will get from when it was subscribed");
        connectableObservable.subscribe(s->System.out.println("Observer2 on Hot Observable==>"+s));
        Thread.sleep(10000);

    }

}
