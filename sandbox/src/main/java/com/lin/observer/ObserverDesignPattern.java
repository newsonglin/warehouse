package com.lin.observer;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/13/2021
 */
public class ObserverDesignPattern {
    public static void main(String[] args) {
        Book book = new Book("Design Pattern","Computer&Science", "David Tark",129.99,"Sold Out");

        EndUser zhang = new EndUser("Zhang", book);
        EndUser wang = new EndUser("Wang", book);
        EndUser li = new EndUser("Li", book);
        EndUser zhao = new EndUser("Zhao", book);

        System.out.println(book.getInStock());

        book.setInStock("In Stock");

    }
}
