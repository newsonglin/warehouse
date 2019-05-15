package com.lin.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;

/**
 * This file was created by Songlin Li on 2015/11/13.
 * It is used for file operations
 */
public class FileService {
    private static FileService _instance;
    private static Logger log = Logger.getLogger(CommandService.class);


    /**
     * Singleton patter, private the constructor method
     */
    private FileService(){
    }


    /**
     * Get file name without extension
     * @param fileName the original file name
     * @return file name without extension
     */
    public static String getFileNameWithoutExtension(String fileName){
        if(StringUtils.isNotEmpty(fileName)&& fileName.contains("."))
            return fileName.substring(0, fileName.indexOf("."));
        else{
            return fileName;
        }
    }
    /**
     * Guest tomcat log file name
     * @return tomcat log file name
     */
    public static String getTomcatLogFileName(String logDirectory){

        String logName=getDefaultTomcatLogFileName();
        if(StringUtils.isEmpty(logDirectory)){
            return logName;
        }

        File logDir= new File(logDirectory);
        File[] fileList=logDir.listFiles();
        if(fileList==null||fileList.length==0){
            return logName;
        }
        long preLastModified=0l;
        for(File file:fileList){
            if(file.isFile() && file.getName().startsWith("catalina")&&file.lastModified()>preLastModified){
                preLastModified=file.lastModified();
                logName=file.getName();
            }
        }

        return logName;
    }

    /**
     * Guest tomcat log file name, the log file name is generated based on current date
     * @return tomcat log file name
     */
    private static String getDefaultTomcatLogFileName(){
        Calendar cal = Calendar.getInstance();
        return "catalina."+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+".log";
    }
    /**
     * Check whether current file contain certain keyword, as long as file contain any of keyword,
     * true will be returned, otherwise false will be returned
     * @param fileAbsolutePath the file object
     * @param containWords this is a set which contains all possible key words to be check
     * @return a boolean type
     */
     public static boolean contain(String fileAbsolutePath, Set<String> containWords){
        File file = new File(fileAbsolutePath);
        return contain(file,containWords);
    }
    /**
     * Check whether current file contain certain keyword, as long as file contain any of keyword,
     * true will be returned, otherwise false will be returned
     * @param file the file object
     * @param containWords this is a set which contains all possible key words to be check
     * @return a boolean type
     */
    public static boolean contain(File file, Set<String> containWords) {

        boolean isContain = false;
        try {
            Scanner scanner = new Scanner(file);
            //now read the file line by line...
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line == null || line.trim().equals("")) {
                    continue;
                }
                for (String word : containWords) {
                    if (line.contains(word)) {
                        isContain = true;
                        return isContain;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            log.error("File Not Found"+e.getMessage());
        }
        return isContain;
    }

    /**
     * Update the specified file with specified content
     * @param fileAbsolutePath the full absolute path of file
     * @param content the new content
     * @return a boolean type, success of fail
     */
    public boolean updateFile(String fileAbsolutePath, String content) {
        if (StringUtils.isEmpty(fileAbsolutePath) || StringUtils.isEmpty(content)) {
            return false;
        }


        try {
            File file = new File(fileAbsolutePath);

            // if file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Singleton pattern to get instance of command service
     *
     * @return an instance of command service
     */
    public static FileService getInstance() {
        if (_instance == null) {
            _instance = new FileService();
        }
        return _instance;
    }

    public static void main(String[] args) {
     Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);//Everyday
        cal.set(1998, month, day+1, 05, 00, 00);

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        Calendar cal2=Calendar.getInstance();
        System.out.println(cal2.get(Calendar.DAY_OF_MONTH));
    }
}
