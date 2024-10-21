package com.lin.rxjava;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/14/2021
 */
public class HelloRxJava {


    public static void main(String[] args) throws Exception {

        test().subscribe();

    }

    public static Single<List<Person>> test (){

        Person person = new Person(LocalDate.of(2024,8,3),"1");
        Person person2 = new Person(LocalDate.of(2024,9,3),"1");
        Person person3= new Person(LocalDate.of(2024,3,3),"1");
        Person person4 = new Person(LocalDate.of(2024,5,3),"2");
        Person person5 = new Person(LocalDate.of(2024,4,3),"2");
        Person person6 = new Person(LocalDate.of(2024,3,3),"3");
        Person person7 = new Person(LocalDate.of(2024,2,3),"2");
        Person person8 = new Person(LocalDate.of(2024,11,3),"3");
        Person person9 = new Person(LocalDate.of(2024,12,3),"3");
        List<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        list.add(person7);
        list.add(person8);
        list.add(person9);

        return

        Observable.fromIterable(list)
                .filter(p->p.getId().equals("4"))
                .flatMap(p->{
                    System.out.println("====1111==");
                    return Observable.just(p);
                })
                .flatMap(p->{
                    return Observable.just(p).filter(px->px.getBod().getYear()>2025).switchIfEmpty(
                            Observable.defer(()-> {
                                System.out.println("list ==== ");
                                return Observable.just(person2);
                            }
                    ));
                })
                .toList();


    }

    private static Person createOnePerson(){
        System.out.println("Create person ....");
        Person p= new Person(LocalDate.of(2024,12,3),"3");
        System.out.println("Create person Over");
        return p;
    }
    public static Completable completableTest(List<Person> list) {

        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Then Flat Map" + finalI + "==started...");
            });
            thread.start();
        }
        return Completable.complete();
    }
    public static Single<String> getSingle22() throws Exception {
        return Single.just("Hello22");
        //        throw new Exception("Not implemented");
    }


}

class Person{
    private LocalDate bod;
    private String id;

    public Person(LocalDate bod, String id) {
        this.bod = bod;
        this.id = id;
    }

    public LocalDate getBod() {
        return bod;
    }

    public void setBod(LocalDate bod) {
        this.bod = bod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
