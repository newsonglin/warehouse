package com.lin.encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RSA (Rivest–Shamir–Adleman) is one of the first public-key cryptosystems
 * and is widely used for secure data transmission.The acronym RSA is the initial
 * letters of the surnames of Ron Rivest, Adi Shamir, and Leonard Adleman,
 * who publicly described the algorithm in 1977. (So early...)
 */
public class RSA {

    private final static String RSA_PRIVATE_KEY = "www.songlin.li.com";
    private final static String RSA_CHARSET = "UTF-8";
    private final static String RSA_ALGORITHM = "RSA";
    private final static int RSA_KEY_SIZE = 1024;

    /**
     * Generic the Random publicKey and privateKey
     *
     * @return index 0: publicKey String; index 1: privateKey String.
     * @throws NoSuchAlgorithmException
     */
    public static Map<Integer, String> genKeyPair() throws NoSuchAlgorithmException {
        Map<Integer, String> keyMap = new HashMap<Integer, String>();
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGen.initialize(RSA_KEY_SIZE, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        keyMap.put(0, publicKeyString);
        keyMap.put(1, privateKeyString);
        return keyMap;
    }

    /**
     * RSA encrypt message with publicKey
     *
     * @param message   Message need to be encrypted
     * @param publicKey
     * @return cipher
     * @throws Exception
     */
    public static String encrypt(String message, String publicKey) throws Exception {
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(RSA_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(message.getBytes(RSA_CHARSET)));
        return outStr;
    }

    /**
     * RSA decrypt cipher with the default privateKey
     *
     * @param message message been encrypt and format with SHA1WithRSABASE64{cipher}
     * @return inscription
     * @throws Exception
     */
    public static String decrypt(String message) throws Exception {
        Pattern pattern = Pattern.compile("(?<=SHA1WithRSABASE64\\{).*(?=})");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            message = matcher.group();
        } else {
            return message;
        }

        byte[] inputByte = Base64.decodeBase64(message.getBytes(RSA_CHARSET));
        byte[] decoded = Base64.decodeBase64(RSA_PRIVATE_KEY);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(RSA_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


    public static void main(String[] args) throws Exception{
        System.out.println(RSA.decrypt("SHA1WithRSABASE64{GpiHoVnZP/2QUydlw1vDx+NDsiDlxPgvXIPl+Kylwyw1YPLvQBQsmmaE9+yZmqNjFiY/xPmkuSa4ug4MWHjsYaJ14+elsZpvmyktlYpNT8bhhdQmTMywYgUFFx2sTIw1ntNPQ4colqcnQS/05mK+aJmmvdZyHcT+V4oyOgu+Efg=}"));


    }
}
