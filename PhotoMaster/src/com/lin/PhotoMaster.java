package com.lin;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Main class to perform photo operations
 *
 * @author Songlin Li
 * @since 2018/01/29
 */
public class PhotoMaster {


    /**
     * 处理此目录下所有照片，把它们按目录分类
     *
     * @param dirToBeProcessed
     */
    private void process(String dirToBeProcessed) {
        Path filePath = new File(dirToBeProcessed).toPath();
        try {
            Files.list(filePath).forEach(path -> {
                if(Files.isDirectory(path)){
                    //We don't care about directory now
                }else{
                    groupByFile(path);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把一个文件按照它的最后修改日期，移到相应的目录里面去
     * @param path  要操作的文件路径
     */
    private void groupByFile(Path path) {
        try {
            File file = path.toFile();

            //Get photo taken date


            Metadata metadata = ImageMetadataReader.readMetadata(file);
            ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL, TimeZone.getTimeZone("GMT+8:00"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String targetFolderName = sdf.format(date);

            String targetFolder = file.getParent() + File.separator + targetFolderName;
            File targetFolderFile=new File(targetFolder);
            if(!targetFolderFile.exists()){
                targetFolderFile.mkdir();
            }

            Path targetPath = new File(targetFolder+File.separator+file.getName()).toPath();


            Files.move(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Move "+file.getName()+" to target folder"+targetPath.toString());

        } catch (Exception e) {
            System.out.println("Move file failed!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        String dirToBeProcessed = args.length > 0 ? args[0] : "";

        //check directory is valid or not
        Path filePath = new File(dirToBeProcessed).toPath();
        boolean isDirectory = Files.isDirectory(filePath);   // Check if it's a directory
        if(!isDirectory){
            System.out.println(" Incorrect parameter! please specify a correct directory");
        }else{
            PhotoMaster pm=new PhotoMaster();
            pm.process(dirToBeProcessed);
        }

    }
}
