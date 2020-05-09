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
            byte[] plainTextByte = source.getBytes();


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
            System.out.println("AESKey=" + AESKey);
            System.out.print("AESKey.getBytes(" + characterEncoding + ")=");
            printBytes(AESKey.getBytes(characterEncoding));
            System.out.println("");

            System.out.print("messageDigest.digest(AESKey.getBytes(" + characterEncoding + ")=");
            printBytes(messageDigest.digest(AESKey.getBytes(characterEncoding)));

            System.out.println("");

            byte[] key = messageDigest.digest(AESKey.getBytes(characterEncoding));
            byte[] iv = messageDigest.digest(AESIv.getBytes(characterEncoding));

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] decodedValue = Base64.getDecoder().decode(encrypted);
            byte[] decValue = cipher.doFinal(decodedValue);
            return new String(decValue);
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

        String aa = AES.decrypt("RcelNBSIVhzonlqdLu3xhq0MaJkf62tL3yqsUalL4dllPU2YHeQyvOuhkA/Y2cDvEhh1zxeK5IJcQ5zBiIr+2Fzey3LPFClWpTMXAuh7Tbu+HuVe06xfhUMREypSSfjmBv67EhUO6TWIgnuCd4ZEh5nmIZqB6a7JOmS9H2Xjb8IABCU/Pm2hE55aOi+VpTARlNLWKdHwhNuQKbIg5WgaSBGUDXx5HIy6+8+SMaOW1oLn9BdN9g09IdTX7A7ZTewDIsubh2aCJ67UXafDs9TwR4UdOtUWLiPQk7ujAzSKdzHatXnTum8rFrL47ijAs8i9eizJv7zxmX369F/oxT5Qdw==");
        System.out.println(aa);

    }


}
