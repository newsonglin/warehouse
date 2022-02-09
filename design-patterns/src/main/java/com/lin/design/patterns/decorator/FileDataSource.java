package com.lin.design.patterns.decorator;

/**
 * The class in learn/exercises project, it's concrete components provide default implementation for the operations.
 *
 * @author Songlin Li
 * @since 1/27/2022
 */
public class FileDataSource implements DataSource {
    private String data;
    @Override
    public void writeData(String data) {
        System.out.println("Write data:"+data);
        this.data=data;
    }

    @Override
    public String readData() {
        return data;
    }
}
