package com.lin.rxjava;

import io.reactivex.rxjava3.core.Observable;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/14/2021
 */
public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("hello");
            emitter.onNext("world");
        });


        source.subscribe(System.out::println);
        source.subscribe(System.out::println);
        source.subscribe(System.out::println);

        source.map(s->s.toUpperCase()).subscribe(System.out::println);





        Observable.just(1,2,3,4,5,6,7,8,9)
        .scan((x,y)-> x+y).subscribe(System.out::println);



    }
}
