package com.lin.observer;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/13/2021
 */
public interface SubjectLibrary {
    void subscribeObserver(Observer ob);

    void unSubscribeObserver(Observer ob);

    void notifyObservers();
}
