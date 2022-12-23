package com.lin.zip.db;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Test {

    public static void main(String[] args) throws Exception{



        byte[] zipContent=getFileBytes("d:/test/Downloads.zip");
        byte[] fileContent=getFileBytes("d:/test/file.txt");;

        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(zipContent), StandardCharsets.UTF_8);

//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ZipOutputStream zipOutputStream = new ZipOutputStream(bos);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("d:/test/tmp.zip"));;

        byte[] buffer = new byte[8192];
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            ZipEntry newEntry = new ZipEntry(entry.getName());
            if(entry.getName().equals("U1111022.txt")){
                continue;
            }
            zipOutputStream.putNextEntry(newEntry);
            int length;
            while ((length = zipInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, length);
            }
            zipOutputStream.closeEntry();

            zipInputStream.closeEntry();
        }
        zipInputStream.close();

        zipOutputStream.putNextEntry(new ZipEntry("U1111022.txt"));
        zipOutputStream.write(fileContent, 0, fileContent.length);
        zipOutputStream.closeEntry();

        zipOutputStream.close();
    }

    private static byte[] getFileBytes(String path) throws Exception{
        return Files.readAllBytes(Paths.get(path));
    }
}
