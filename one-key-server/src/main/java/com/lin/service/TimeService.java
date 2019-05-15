package com.lin.service;

/**
 * This file was created by Songlin Li on 2015/11/13.
 * It is used for time check
 */
public class TimeService {
    private static TimeService ourInstance = new TimeService();

    public static TimeService getInstance() {
        return ourInstance;
    }

    private TimeService() {
    }

    public static void waitInMinutes(int minutes) {
        waitInSeconds(minutes * 60);
    }

    public static void waitInSeconds(int seconds) {
        try {
            for (int i = seconds; i > 0; i--) {
                Thread.sleep(1000);
                System.out.printf("\r %5d seconds left", i-1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        TimeService timeService = TimeService.getInstance();
        timeService.waitInMinutes(2);
    }
}
