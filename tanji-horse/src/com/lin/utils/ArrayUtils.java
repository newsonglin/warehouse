package com.lin.utils;

import java.util.Random;

public class ArrayUtils {

    public static void randomArray(Object[] array){
        Random random = new Random();
        for(int index=array.length-1;index>=0;index--){
            int radomIndex=random.nextInt(index+1);
            Object temp=array[radomIndex];
            array[radomIndex]=array[index];
            array[index]=temp;
        }



    }

    public static void printArray(Object[] array){
        for(int index=0; index<array.length; index++) {
            System.out.print(array[index].toString()+" ");
        }
        System.out.println();
    }
}
