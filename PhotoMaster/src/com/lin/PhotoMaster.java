package com.lin;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

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
     * @param dirToBeProcessed directory to be processed
     */
    private void process(String dirToBeProcessed) {
        Path filePath = new File(dirToBeProcessed).toPath();
        try {
            Files.list(filePath).forEach(path -> {
                if (!Files.isDirectory(path)) {
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

            //Get photo taken place;
//            GeoLocation location=getTakenPlace(file);
//            if(location!=null) {
//                System.out.println("Longitude:" + location.getLongitude() + " | Latitude:" + location.getLatitude());
//            }

            //Get photo taken date
            Date date = getTakenDate(file);
            if(date==null){//taken date is null
               date=getCreationDate(file);
            }

            if(date==null) {
                date = new Date(file.lastModified());//last modified date
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String targetFolderName = sdf.format(date);

            String targetFolder = file.getParent() + File.separator + targetFolderName;
            File targetFolderFile=new File(targetFolder);
            if(!targetFolderFile.exists()){
                targetFolderFile.mkdir();
            }

            Path targetPath = new File(targetFolder+File.separator+file.getName()).toPath();


            Files.move(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("移动文件 "+file.getName()+" 到目录 "+targetPath.toString());

        } catch (Exception e) {
            System.out.println("Move file failed!");
            e.printStackTrace();
        }

    }

    /**
     * 获取照片拍摄日期
     * @param file  当前照片
     * @return  照片拍摄日期
     * @throws ImageProcessingException 照片处理错误
     * @throws IOException 照片读取错误
     */
    private Date getTakenDate(File file) {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            return directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL, TimeZone.getTimeZone("GMT+8:00"));
        }catch (Exception e) {
            //e.printStackTrace();
            System.out.println("未能获取照片"+file.getName()+"的拍摄日期, 将会使用创建日期代替 ");
            return null;
        }
    }


    /**
     * 获取照片拍摄地点
     * @param file  当前照片
     * @return  照片拍摄地点
     * @throws ImageProcessingException 照片处理错误
     * @throws IOException 照片读取错误
     */
    private GeoLocation getTakenPlace(File file) {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            GpsDirectory directory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
            if(directory!=null) {
                return directory.getGeoLocation();
            }

        }catch (Exception e) {
            //e.printStackTrace();
            System.out.println("未能获取照片"+file.getName()+"的拍摄地点");
            return null;
        }
        return null;
    }

    /**
     * 获取文件创建日期
     * @param file 当前文件
     * @return 文件创建日期
     */
    private Date getCreationDate(File file) {
        Date creationDate = null;
        Path filePath = file.toPath();

        BasicFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
        } catch (IOException exception) {
            System.out.println("Exception handled when trying to get file " + "attributes: " + exception.getMessage());
            return creationDate;
        }
        long milliseconds = attributes.creationTime().to(TimeUnit.MILLISECONDS);
        if ((milliseconds > Long.MIN_VALUE) && (milliseconds < Long.MAX_VALUE)) {
            creationDate = new Date(attributes.creationTime().to(TimeUnit.MILLISECONDS));


        }

        return creationDate;
    }

    public static void main(String[] args) {

        String dirToBeProcessed = args.length > 0 ? args[0] : null;

        if(dirToBeProcessed==null ||"".equals(dirToBeProcessed)){
            System.out.println(" 参数不正确，后面必须跟一个有效文件夹路径");
            System.out.println(" 例如 PhotoMaster c:\\abc\\");
            System.exit(1);
        }

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
