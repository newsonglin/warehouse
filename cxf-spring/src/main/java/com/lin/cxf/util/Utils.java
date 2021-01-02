package com.lin.cxf.util;

import java.nio.charset.StandardCharsets;

public class Utils {

    public static void main(String[] args) throws Exception {

        String s = "李松林";
        System.out.println(s.getBytes("GBK").length);
        System.out.println(s.getBytes("Big5").length);
        System.out.println(s.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(s.getBytes(StandardCharsets.UTF_16).length);
        System.out.println(s.getBytes(StandardCharsets.ISO_8859_1).length);

    }



    /* s must be an even-length string. */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
