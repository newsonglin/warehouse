package com.lin.utils;

public class StringUtils {

    public static String blanks(int length){
        String result="";
        for(int i=0;i<length-1;i++){
            result=result+" ";
        }
        return result;
    }
}
