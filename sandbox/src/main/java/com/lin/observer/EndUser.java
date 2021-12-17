package com.lin.observer;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/13/2021
 */
public class EndUser implements Observer {

    private  String name;

    public EndUser(String name, SubjectLibrary subjectLibrary) {
        this.name = name;
        subjectLibrary.subscribeObserver(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String available) {
        System.out.println("Hello "+name+",  We are glad to notify you that your book is now "+available);
    }
}
