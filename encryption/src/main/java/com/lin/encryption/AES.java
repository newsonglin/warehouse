package com.lin.encryption;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AES {

    private static final String characterEncoding = "utf-16LE";

    private static final String AESKey = "www.songlin.li.com";
    private static final String AESIv = "www.songlin.li.com";

    public static String encrypt(String source) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] key = messageDigest.digest(AESKey.getBytes(characterEncoding));
            byte[] iv = messageDigest.digest(AESIv.getBytes(characterEncoding));

            byte[] plainTextByte = source.getBytes(characterEncoding);


            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return Base64.getEncoder().encodeToString(cipher.doFinal(plainTextByte));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, e);
        }
        return "";
    }


    public static String decrypt(String encrypted) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            System.out.println("AESKey=" + AESKey);characterEncoding

//            System.out.print("AESKey.getBytes(" + characterEncoding + ")=");
            printBytes(AESKey.getBytes(characterEncoding));
//            System.out.println("");

//            System.out.print("messageDigest.digest(AESKey.getBytes(" + characterEncoding + ")=");
            printBytes(messageDigest.digest(AESKey.getBytes(characterEncoding)));

//            System.out.println("");

            byte[] key = messageDigest.digest(AESKey.getBytes(characterEncoding));
            byte[] iv = messageDigest.digest(AESIv.getBytes(characterEncoding));

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] decodedValue = Base64.getDecoder().decode(encrypted);
            byte[] decValue = cipher.doFinal(decodedValue);
            return new String(decValue,characterEncoding);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException | UnsupportedEncodingException e) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }


    public static void printBytes(byte[] a) {
        for (int i = 0; i < a.length; i++) {
//            System.out.print(String.format("%02X ", a[i]) +" ");
        }
    }

    public static void main(String[] args) {

        String xxx = AES.decrypt("RcelNBSIVhzonlqdLu3xhq0MaJkf62tL3yqsUalL4dllPU2YHeQyvOuhkA/Y2cDvEhh1zxeK5IJcQ5zBiIr+2Fzey3LPFClWpTMXAuh7Tbu+HuVe06xfhUMREypSSfjmBv67EhUO6TWIgnuCd4ZEh5nmIZqB6a7JOmS9H2Xjb8IABCU/Pm2hE55aOi+VpTARlNLWKdHwhNuQKbIg5WgaSBGUDXx5HIy6+8+SMaOW1oLn9BdN9g09IdTX7A7ZTewDIsubh2aCJ67UXafDs9TwR4UdOtUWLiPQk7ujAzSKdzHatXnTum8rFrL47ijAs8i9eizJv7zxmX369F/oxT5Qdw==");
        String alex = AES.decrypt("XAeg2TotZywOXmCJIk0ubhWpopxzylfpIYNDQy6Rny28pB91GkmhOHgl4gaKQ/5uDklFQHCvr01WXZGY/LuvxjoS87qzDvlMPjFogm6NVXT21FjbaEjUFyAt3y27xawF4DxHF6id3MYBlJq6xoWCqOj684OF3ZPN4k5fAY/REuGWZy9gl1Gvkn0b0/y1SW6tstt5YMl+BhJvre9O+hc0Ts/KagpYxxGD3CqF5UPdHlWpMdNV7chbyVb3z+Qeuat7IyevmpcOetrPgAqnBIlr4VCYoPr56qAjgNL7+iVth1Hq18ZTRy/8ryub5s49B3bSthW56Kc9qAj7qcgynXDWcM1IEo8PdW7GqpdeA/iAVoxrVxXj8j/TqMOA+9/6Wul8iCJLs1owvjgViPPk3zESqw==");
        System.out.println(xxx);
        System.out.println(alex);


        String newTest="{\n" +
                "  \"TNO\" : \"DemoSite20200701005114\",\n" +
                "  \"SID\" : \"TestSys\",\n" +
                "  \"SysName\" : \"TestSys\",\n" +
                "  \"ONO\" : \"20200630222005845\",\n" +
                "  \"Amount\" : 100,\n" +
                "  \"PayDeadline\" : \"20200630\",\n" +
                "  \"LastTimeTNO\" : \"A123456789\",\n" +
                "  \"TransMode\" : \"0\",\n" +
                "  \"Other\" : null,\n" +
                "  \"RsURL\" : \"http://localhost:8080/hot-app\"\n" +
                "}";
        String newEncrypt=AES.encrypt(newTest);
        System.out.println(AES.decrypt(newEncrypt));


    }


}
