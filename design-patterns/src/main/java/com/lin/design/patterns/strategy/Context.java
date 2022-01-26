package com.lin.design.patterns.strategy;

/**
 * The class in learn/exercises project
 * The context defines the interface of interest to clients.
 * @author Songlin Li
 * @since 1/26/2022
 */
public class Context <T> {
    // The context maintains a reference to one of the strategy
    // objects. The context doesn't know the concrete class of a
    // strategy. It should work with all strategies via the
    // strategy interface.
    private Strategy<T> strategy;

    /**
     * Usually the context accepts a strategy through the constructor, and also provides a setter
     * so that the strategy can be switched at runtime.
     * @param strategy the strategy to be used at runtime
     */
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }

    /**
     * The context delegates some work to the strategy object instead of implementing multiple versions
     * of the algorithm on its own.
     * @param a
     * @param b
     * @return
     */
    public T executeStrategy(T a, T b){
        return strategy.execute(a,b);
    }

}
