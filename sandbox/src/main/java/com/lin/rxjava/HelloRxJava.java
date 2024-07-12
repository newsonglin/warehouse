package com.lin.rxjava;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/14/2021
 */
public class HelloRxJava {


    public static void main(String[] args) throws Exception {
     /*   Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("hello");
            emitter.onNext("world");
        });


        source.subscribe(System.out::println);
        source.subscribe(System.out::println);
        source.subscribe(System.out::println);

        source.map(s->s.toUpperCase()).subscribe(System.out::println);





        Observable.just()
        .scan((x,y)-> x+y).subscribe(System.out::println);
*/
//
//        System.out.println("******** Using flatMap() *********");
//        Observable.range(1, 15)
//                .firstElement()
//                .flatMapCompletable(ignore->{
//                    System.out.println("ignore = " + ignore);
//                    return Completable.complete();
//                }).blockingAwait();

//        final HelloRxJava rxJava = new HelloRxJava();
//        Maybe<String> ha = Observable.just(1, 2, 3, 4, 5, 6)
//                .filter(i -> i > 6)
//                .firstElement()
//                .flatMapSingle(i -> rxJava.getSingle())
//                .onErrorReturnItem("ss")
//                .map(a -> new String("dfdf"))
//                .filter(s->true)
//                .switchIfEmpty(Maybe.empty());
//        System.out.println("ha.blockingGet() = " + ha.blockingGet());


    }

    public static Single<String> test (){
        return Single.just(1).flatMap(e->{
            if(e==1){
                return getSingle();
            }
            if(e==2){
                return getSingle22();
            }
            return Single.just("default");
        });
    }
    public static Single<String> getSingle() throws Exception {
        return Single.just("Hello");
//        throw new Exception("Not implemented");
    }
    public static Single<String> getSingle22() throws Exception {
        return Single.just("Hello22");
        //        throw new Exception("Not implemented");
    }
}
