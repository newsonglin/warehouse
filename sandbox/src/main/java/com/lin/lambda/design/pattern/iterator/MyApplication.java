package com.lin.lambda.design.pattern.iterator;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/2/2021
 */
public class MyApplication {
    public static void main(String[] args) {
        MyCollection collection=new MyCollection(new String[]{"Li","Song","Lin","Bei","Li","Lou"});
        collection.forEach(System.out::println);
    }
}
