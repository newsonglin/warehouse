package com.lin.design.patterns.strategy;

/**
 * The class in learn/exercises project
 *  Concrete strategies implement the algorithm while following
 *  the base strategy interface. The interface makes them
 *  interchangeable in the context.
 *
 * @author Songlin Li
 * @since 1/26/2022
 */
public class ConcreteStrategyAdd implements  Strategy<Integer>{

    @Override
    public Integer execute(Integer a, Integer b) {
        return a+b;
    }
}
