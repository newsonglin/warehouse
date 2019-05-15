package com.lin.tools;

import com.lin.OneKeyServerApp;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This file was created by Songlin Li on 2015/12/02.
 * It is used for automatically execute some tasks
 */
public class Scheduler {
    private static Logger log = Logger.getLogger(Scheduler.class);

    private static Date executedTime;
    private static int logPeriod =1000*5*1;//20 minutes
    private static int taskPeriod=1000*60*1;// 1 day
    private static int count = 0;
    private static OneKeyServerApp app = new OneKeyServerApp();

    public static void execute() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ++count;
                log.info(" Task was" + " executed " + count + " time(s)");
                app.startupExternalServer();
                executedTime =new Date(executedTime.getTime()+taskPeriod);
            }
        };

        TimerTask logTask = new TimerTask() {
            @Override
            public void run() {
                log.info("Current time is:"+new Date() +"; Task execution time is:"+ executedTime +". Waiting....");
            }
        };

        //Set task start time
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//Everyday
        calendar.set(year, month, day+1, 06, 00, 00);
        executedTime = calendar.getTime();

        //Executed time can't be past, it must be future time
        Date currentTime=new Date();
        while(executedTime.before(currentTime)){
            executedTime.setTime(executedTime.getTime()+taskPeriod);
        }

        Timer timer = new Timer();
        log.info("Task start time is "+ executedTime);


        timer.schedule(logTask, 0,logPeriod);//Log task will be started right now
        timer.schedule(task, executedTime, taskPeriod);


    }

    public static void main(String[] args) {
        execute();
    }
}
