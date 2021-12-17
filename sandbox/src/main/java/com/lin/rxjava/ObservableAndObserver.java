package com.lin.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/16/2021
 */
public class ObservableAndObserver {
    public static void main(String[] args) {
        Observable<String> source = new ObservableCreate<String>(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                try {
                    emitter.onNext("Bei");
                    emitter.onNext("Li");
                    emitter.onNext("Lou");
                    String s=null;
                    s.length();
                    emitter.onNext("Cun");
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("on subscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("on next called and next is "+o.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("on error" + e);
            }

            @Override
            public void onComplete() {
                System.out.println("finished");
            }
        };

        source.subscribe(observer);
    }
}
