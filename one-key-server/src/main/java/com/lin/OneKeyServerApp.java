package com.lin;

import com.lin.constants.Status;
import com.lin.service.CommandService;
import com.lin.service.FileService;
import com.lin.service.PropertiesService;
import com.lin.service.TimeService;
import com.lin.tools.Scheduler;
import com.lin.vo.Result;
import org.apache.log4j.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This file was created by Songlin Li on 2015/11/05.
 * It is used for main application of one key server
 */
public class OneKeyServerApp {
    private static Logger log = Logger.getLogger(OneKeyServerApp.class);

    private static CommandService commandService=CommandService.getInstance();

    public static void main(String[] args) {

        OneKeyServerApp app = new OneKeyServerApp();
        if("Yes".equalsIgnoreCase(PropertiesService.get("auto_start"))){
            Scheduler.execute();
        }else {
            app.run();
        }
//        app.changeServerDate();
    }

    private void run() {
        Result result;
        log.info("Step 0 of 7: Update server date to current time");
        this.changeServerDate();
        log.info("Step 0 of 7: Update server date to current time finished");

        log.info("Step 1 of 7: Update source code started");
        result=this.updateSource();
        if(result.getStatus()== Status.SUCCESS){
            log.info("Step 1 of 7: Update source code finished");
            log.info("Step 2 of 7:Start to build");
            result=this.build();
        }else{
            log.error("Step 1 of 7: Update source code failed" + result.getMessage());
            return;
        }

        if(result.getStatus()== Status.SUCCESS){
            log.info("Step 2 of 7:build finished");
            log.info("Step 3 of 7:Start update Liquibase");
            result=this.updatDB();
        }else{
            return;
        }

        if(result.getStatus()== Status.SUCCESS){
            log.info("Step 3 of 7:Finish update Liquibase");
            log.info("Step 4 of 7:Begin copy admin data");
            result=this.copyAdmin();
        }else{
            return;
        }


        if(result.getStatus()== Status.SUCCESS){
            log.info("Step 4 of 7:Finish copying admin data");
            log.info("Step 5 of 7:Begin Startup external server");
            result=this.startupExternalServer();
        }else{
            return;
        }

        if(result.getStatus()== Status.SUCCESS){
            log.info("Step 5 of 7:Finish startup external server");
            log.info("Step 6 of 7:Begin Startup admin server");
            result=this.startupAdminServer();
        }else{
            return;
        }

        if(result.getStatus()== Status.SUCCESS){
            log.info("Step 6 of 7:Finish startup admin server");
            log.info("Step 7 of 7:Import product");
            this.importProduct();

        }else{
            return;
        }
        log.info("Step 7 of 7:Import product");

    }

    private Result updateSource() {
        CommandService.generateCommandFile("update_source.template");
        String command=System.getProperty("java.io.tmpdir")+"update_source.bat";
        Set<String> checkWords=new HashSet<String>();
        checkWords.add("At revision");
        checkWords.add("Updated to revision");
        return commandService.execute(command,checkWords,true);
    }

    private  Result build(){
        CommandService.generateCommandFile("build.template");
        String command=System.getProperty("java.io.tmpdir")+"build.bat";
        Set<String> checkWords=new HashSet<String>();
        checkWords.add("FAILED");
        checkWords.add("BUILD FAILURE");
        return commandService.execute(command,checkWords,false);
    }

    private Result updatDB() {
        CommandService.generateCommandFile("update_db.template");
        String command = System.getProperty("java.io.tmpdir")+"update_db.bat";
        Set<String> checkWords = new HashSet<String>();
        checkWords.add("Liquibase update Failed");
        return commandService.execute(command, checkWords, false);

    }

    private Result copyAdmin(){
        CommandService.generateCommandFile("copy_admin.template");
        String command=System.getProperty("java.io.tmpdir")+"copy_admin.bat";
        Set<String> checkWords=new HashSet<String>();
        checkWords.add("Failed");
        return commandService.execute(command,checkWords,false);

    }

    private Result importProduct(){
        CommandService.generateCommandFile("import_product.template");
        String command=System.getProperty("java.io.tmpdir")+"import_product.bat";
        Set<String> checkWords=new HashSet<String>();
        checkWords.add("Failed");
        return commandService.execute(command,checkWords,false);

    }
    private Result startupAdminServer(){
        Result result= new Result();
        CommandService.generateCommandFile("start_admin.template");
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd.exe /c start start_admin.bat", null, new File(System.getProperty("java.io.tmpdir")));


            Set<String> checkWords=new HashSet<String>();
            checkWords.add("Server startup in");

            log.info("Now let's wait for server starup");
            TimeService.waitInMinutes(5);
            for (int i=0;i<10;i++){
                log.info("the "+ (i+1)+ " times check server");
                String serverLogName= FileService.getTomcatLogFileName(PropertiesService.get("tomcat_admin_dir")+"\\logs\\");

                if (FileService.contain(PropertiesService.get("tomcat_admin_dir")+"\\logs\\"+serverLogName,checkWords)){
                    //Start up success
                    result.setStatus(Status.SUCCESS);
                    result.setMessage("admins server stared successfully");
                    return result;
                }else{
                    log.info("Didn't find any success info in server log file, wait and try again");
                }
                TimeService.waitInMinutes(5);
            }

            result.setStatus(Status.FAILED);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    public Result startupExternalServer(){
        Result result= new Result();
        CommandService.generateCommandFile("start_external.template");
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd.exe /c start start_external.bat", null, new File(System.getProperty("java.io.tmpdir")));



            Set<String> checkWords=new HashSet<String>();
            checkWords.add("Server startup in");

            log.info("Now let's wait for server starup");
            TimeService.waitInMinutes(5);
            for (int i=0;i<10;i++){
                log.info("the "+ (i+1)+ " times check server");
                String serverLogName= FileService.getTomcatLogFileName(PropertiesService.get("tomcat_external_dir")+"\\logs\\");
                log.debug("Tomcat server log name is:"+serverLogName);
                if (FileService.contain(PropertiesService.get("tomcat_external_dir")+"\\logs\\"+serverLogName,checkWords)){
                    //Start up success
                    result.setStatus(Status.SUCCESS);
                    result.setMessage("Server stared up successfully");
                    return result;
                }else{
                    log.info("Didn't find any success info in server log file, wait and try again");
                }
                TimeService.waitInMinutes(5);
            }

            result.setStatus(Status.FAILED);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    public Result changeServerDate() {
        Result result = new Result();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = sdf.format(new Date());

        String dateshiftLocation = PropertiesService.get("dateshift_location");

        boolean updateResult = FileService.getInstance().updateFile(dateshiftLocation, strDate);
        result.setStatus(updateResult ? Status.SUCCESS : Status.FAILED);

        return result;
    }
}
