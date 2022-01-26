package com.lin.design.patterns.strategy;

/**
 * The class in learn/exercises project
 * The strategy interface declares operations common to all
 * supported versions of some algorithm. The context uses this
 * interface to call the algorithm defined by the concrete
 * strategies.
 * @author Songlin Li
 * @since 1/26/2022
 */
public interface Strategy<T> {
    T execute(T a, T b);
}
