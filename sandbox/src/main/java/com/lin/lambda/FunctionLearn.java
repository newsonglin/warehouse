package com.lin.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * The class in claim project
 *
 * @author Songlin Li
 * @since 1.0
 */
public class FunctionLearn {
    private <T, R> List<R> map(List<T> source, Function<T,R> converter){

        List<R> mappedList=new ArrayList<>();
        for (T element:source){
            mappedList.add(converter.apply(element));
        }

        return mappedList;
    }


    private List<Integer> getElementLength(List<String> src){
        //Function<String, Integer> lenFunc=s->s.length();
        // ||  ||  ||  ||  ||  ||
        // \/  \/  \/  \/  \/  \/
        // Method reference
        Function<String, Integer> lenFunc=String::length;
        return map(src,lenFunc);
    }

    public static void main(String[] args) {
        List<String> testStrList= List.of("Li","Song","Lin","Bei","Li","Lou");
        FunctionLearn fl= new FunctionLearn();
        System.out.println(fl.getElementLength(testStrList));
    }

}
