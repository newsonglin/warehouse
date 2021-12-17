package com.lin.lambda.design.pattern.iterator;

import java.util.function.Consumer;

/**
 * The class in claim project
 *
 * @author Songlin Li
 * @since 1.0
 */
public class MyCollection {

    Object[] elements;

    public MyCollection(Object[] elements) {
        this.elements = elements;
    }


    public void forEach(Consumer<Object> consumer){
        for(int i=0;i<elements.length;i++){
            consumer.accept(elements[i]);
        }
    }
}