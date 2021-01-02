package com.lin.mail;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;

public class FileService {


    public static String encodeFileToBase64Apache(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    public static String encodeFileToBase64(File file) {
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new IllegalStateException("could not read file " + file, e);
        }
    }

    public static void main(String[] args) throws Exception{
        String filePath = "D:\\tmp\\ipb-operational-reports-deploy.jar";
        File f = new File(filePath);
        System.out.println("Original file size:"+f.length());

        System.out.println(encodeFileToBase64Apache(filePath).length());
        System.out.println(encodeFileToBase64(f).length());


    }
}
