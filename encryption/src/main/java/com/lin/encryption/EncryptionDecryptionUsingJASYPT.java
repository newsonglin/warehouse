package com.lin.encryption;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptionDecryptionUsingJASYPT {

    private static String mpCryptoPassword = "www.songlin.li.com";

    public static void main(String[] args) {


        String value = "Original Text: Eclipse";

        System.out.println("Original Value : "+value);
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(mpCryptoPassword);
        String encryptedPassword = encryptor.encrypt(value);
        System.out.println(encryptedPassword);

        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(mpCryptoPassword);
        System.out.println(decryptor.decrypt(encryptedPassword));
    }
}
