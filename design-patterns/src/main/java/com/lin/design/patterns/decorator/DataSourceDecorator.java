package com.lin.design.patterns.decorator;

/**
 * The class in learn/exercises project, it's basic decorator for DataSource
 * 1. It implements interface DataSource
 * 2. It contains DataSource type field variable
 *
 * @author Songlin Li
 * @since 1/27/2022
 */
public class DataSourceDecorator implements DataSource{
    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) {
        // The base decorator simply delegates all work to the
        // wrapped component. Extra behaviors can be added in
        // concrete decorators.
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        // Concrete decorators may call the parent implementation of
        // the operation instead of calling the wrapped object
        // directly. This approach simplifies extension of decorator
        // classes.
        return wrappee.readData();
    }
}
