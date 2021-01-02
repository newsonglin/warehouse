package com.lin.mail;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class Utils {
    /**
     * Calculate original file size from base64 encode string
     *
     * @param base64File the file content in base64 encoded string format
     * @return  file size, please note, if base64File is null or empty, method will return 0
     */
    public static long calculateFileSize(String base64File) {
        //return zero size for empty file
        if (StringUtils.isEmpty(base64File)) {
            return 0L;
        }

        int padding = 0;
        if (base64File.endsWith("==")) {
            padding = 2;
        } else if (base64File.endsWith("=")) {
            padding = 1;
        }
        return base64File.length() * 3 / 4 - padding;
    }

    public static void main(String[] args)  throws Exception{
        String filePath = "D:\\project_management\\xxx\\OMS\\EIS與外部列印管理系統整合方案 1.3.docx";
        File f = new File(filePath);
        System.out.println("Original file size:"+f.length());
        FileService fs= new FileService();

        System.out.println(FileService.encodeFileToBase64Apache(filePath).length());
        System.out.println(FileService.encodeFileToBase64(f).length());

        System.out.println("=="+calculateFileSize(FileService.encodeFileToBase64Apache(filePath)));
        System.out.println("=="+calculateFileSize(FileService.encodeFileToBase64(f)));

    }
}
