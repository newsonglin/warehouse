package com.lin.utils;


/**
 * 操纵文件的实用类
 * @author Songlin Li
 * @since 2018/01/29
 */
public class FileUtils {

    private static FileUtils _instance;
    /**
     * don't allow instance this class
     */
    private FileUtils(){

    }

    public static FileUtils getInstance(){
        if(_instance==null){
            _instance=new FileUtils();
        }
        return _instance;
    }




}
