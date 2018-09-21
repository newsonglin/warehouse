package com.lin;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class Test {

    public static void main(String[] args) {
        try {
            int a=10;
            a=a*100;
            String s=null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("sssssssssssssssssssssssssssss");
        }

    }
}
