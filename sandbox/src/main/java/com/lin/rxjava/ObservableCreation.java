package com.lin.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/16/2021
 */
public class ObservableCreation {
    public static void main(String[] args) {
        //Create
        Observable<String> source=Observable.create( e->{
        e.onNext("Bei");
        e.onNext("Li");
        e.onNext("Lou");
        e.onComplete();
        });
        source.subscribe(System.out::println);

        //Just
        Observable<String> just=Observable.just("Bei", "Li", "Lou");
        just.subscribe(System.out::println);

        //FromIterator
        List<String> list= List.of("Bei", "Li", "Lou");
        Observable.fromIterable(list).subscribe(System.out::println);

        //Range
        Observable.range(1,5).subscribe(System.out::println);

        //Interval
        Observable.interval(3, TimeUnit.SECONDS).subscribe(System.out::println);


        //Defer
        SomeType instance = new SomeType();
        Observable<String> value = instance.valueObservable();
        Observable<String> valueDefer=instance.valueObservableDefer();
        instance.setValue("Some Value");
        value.subscribe(System.out::println);
        valueDefer.subscribe(System.out::println);
    }
}

class SomeType {
    private String value="InitValue";

    public void setValue(String value) {
        this.value = value;
    }

    public Observable<String> valueObservable() {
        return Observable.just(value);
    }
    public Observable<String> valueObservableDefer() {
        return Observable.defer(()->Observable.just(value));
    }

}
