package com.lin.encryption;

import org.apache.commons.codec.binary.Base64;
import sun.nio.cs.UTF_32;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AES4ImageSystem {
    private static String AES_CHARSET = "utf-8";
    private static String AES_ALGORITHM = "AES";
    private static String AES_PADDING = "AES/ECB/PKCS5Padding";
    private static String MD5 = "MD5";
    private static String DATE_FORMAT = "yyyyMMdd";

    public static String encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.println("Key is null");
            throw new IllegalArgumentException("Key is required.");
        }
        byte[] raw = getMD5(sKey);
        if (raw.length != 16) {
            System.out.println("Key length is not 16");
            throw new InvalidKeyException("Key is not supported.");
        }
        SecretKeySpec skeySpec = new SecretKeySpec(raw, AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(AES_CHARSET));
        return new Base64().encodeToString(encrypted);
    }

    public static String decrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.println("Key is null");
            throw new IllegalArgumentException("Key is required.");
        }
        byte[] raw = getMD5(sKey);
        System.out.println("MD5=========="+new String(raw));
        if (raw.length != 16) {
            System.out.println("Key length is not 16");
            throw new InvalidKeyException("Key is not supported.");
        }
        SecretKeySpec skeySpec = new SecretKeySpec(raw, AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted1 = new Base64().decode(sSrc);
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original,AES_CHARSET);
        return originalString;
    }

    private static String getEncryptedPass(String pass) throws Exception{

        String key = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        return encrypt(pass, key);
    }
    /**
     * get MD5
     *
     * @param securityStr key
     * @return MD5
     */
    public static byte[] getMD5(String securityStr) throws NoSuchAlgorithmException {
        byte[] btInput = securityStr.getBytes();
        MessageDigest mdInst = MessageDigest.getInstance(MD5);
        mdInst.update(btInput);
        return mdInst.digest();
    }

    public static void main(String[] args) throws  Exception{
        String encryptedPass=getEncryptedPass("@a234567");
        System.out.println(encryptedPass);
        String key = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        System.out.println("key="+key);
        System.out.println("encryptedPass="+encryptedPass);

        String pass=decrypt("7gcgs+clqYsnmlgC8HI2hw==",key);
        System.out.println("pass="+pass);

    }
}
