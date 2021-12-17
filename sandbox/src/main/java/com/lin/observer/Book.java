package com.lin.observer;

import java.util.ArrayList;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/13/2021
 */
public class Book implements SubjectLibrary {
    private String name;
    private String type;
    private String author;
    private double price;
    private String inStock;
    private ArrayList<Observer> observers = new ArrayList<>();


    @Override
    public void subscribeObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void unSubscribeObserver(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Book Name:" + this.name +
                ",Type:" + this.type +
                ",Price:$" + this.price +
                ",Author:" + this.author +
                "is now " + this.inStock + ". So, please notify all users.\n");

        observers.forEach(observer -> observer.update(this.inStock));
    }

    public Book(String name, String type, String author, double price, String inStock) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        System.out.println("Availability is changed from sold out to in stock, notify all observers ");
        notifyObservers();
    }
}
