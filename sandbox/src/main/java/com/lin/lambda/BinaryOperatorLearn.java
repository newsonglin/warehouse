package com.lin.lambda;

import java.util.function.BinaryOperator;

/**
 * The class in claim project
 *
 * @author Songlin Li
 * @since 1.0
 */
public class BinaryOperatorLearn {
    public static void main(String[] args) {

        //BinaryOperator "T apply(T t, T u)"
        BinaryOperator<String> operator= (a,b)->a+"."+b;
        BinaryOperator<Integer> intOperator=(a,b)->a*100+b*10;

        System.out.println(operator.apply("FirstName","LastName"));
        System.out.println(intOperator.apply(10,33));

    }
}
