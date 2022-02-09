package com.lin.design.patterns.decorator;

/**
 * The class in learn/exercises project, it is base component interface and can be decorated later
 *
 * @author Songlin Li
 * @since 1/27/2022
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
