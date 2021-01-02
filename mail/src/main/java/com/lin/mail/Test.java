package com.lin.mail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String text = sdf.format(date);

        System.out.println("text = " + text);

    }
}
