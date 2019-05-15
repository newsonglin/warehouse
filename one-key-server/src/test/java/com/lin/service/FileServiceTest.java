package com.lin.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * This file was created by Songlin Li on 2015/11/24.
 * It is used for FileService test
 */
public class FileServiceTest {
    private FileService testInstance=FileService.getInstance();
    @Test
    public void testGetFileNameWithoutExtension(){
        Assert.assertNull(testInstance.getFileNameWithoutExtension(null));
        Assert.assertEquals(testInstance.getFileNameWithoutExtension(""),"");
        Assert.assertEquals(testInstance.getFileNameWithoutExtension("   "),"   ");
        Assert.assertEquals(testInstance.getFileNameWithoutExtension("exampleFileName"),"exampleFileName");
        Assert.assertEquals(testInstance.getFileNameWithoutExtension("exampleFileName.ext"),"exampleFileName");
    }

    @Test
    public void testGetTomcatLogFileName(){

        String logName=testInstance.getTomcatLogFileName("D:\\tomcat\\PAS06_1\\app\\logs");
        Assert.assertNotNull(logName);
        Assert.assertTrue(logName.startsWith("catalina"));

        logName=testInstance.getTomcatLogFileName("Any Directory");
        Assert.assertNotNull(logName);
        Assert.assertTrue(logName.startsWith("catalina"));
    }

    @Test
    public void testUpdateFile(){

        Assert.assertFalse(testInstance.updateFile(null,null));

        String tempFilePath=System.getProperty("java.io.tmpdir")+"test.txt";

        String updatecontent="This is content to be updated into file";

        boolean result = testInstance.updateFile(tempFilePath,updatecontent);
        Assert.assertTrue(result);
    }
}
