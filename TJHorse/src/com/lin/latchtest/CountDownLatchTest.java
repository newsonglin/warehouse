package com.lin.latchtest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 代表裁判的类，他要等所有队员完成本关，才能发通关证书
 */
class Referee implements Runnable{
    private CountDownLatch countDownLatch;

    public Referee(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("关口裁判等待所有人过关........");
        try {
            //等待所有人完成，也就是count down latch变成零，才能执行后继操作
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //等代码执行到这里，说明计数器已经变成零
        System.out.println("关口裁判验证完毕所有团队成员，整个团队可以进行下一关........");

    }
}

/**
 * 代表团队里每个队员的类
 */
class TeamMember implements  Runnable{
    private CountDownLatch countDownLatch;
    private int teamNumber;

    public TeamMember(CountDownLatch countDownLatch, int teamNumber) {
        this.countDownLatch = countDownLatch;
        this.teamNumber = teamNumber;
    }

    @Override
    public void run() {
        System.out.println("队员"+this.teamNumber+"开始闯关........");
        //让线程睡一段时间来模拟队员闯关所用时间
        try {
            Thread.sleep(new Random().nextInt(5)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("队员"+this.teamNumber+"闯关完成........");
        //队员闯关完成，计数器减一， 这个是线程安全的操作，不用担心其它线程也在同时减一
        countDownLatch.countDown();

        System.out.println("还有 "+countDownLatch.getCount()+" 正在闯关");

    }
}

/**
 * 具体测试类
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        //初始化数值10， 对应10个队员
        CountDownLatch countDownLatch=new CountDownLatch(10);

        //裁判就位
        Referee referee=new Referee(countDownLatch);
        Thread refreeThread= new Thread(referee);
        refreeThread.start();

        //10个队员闯关开始
        for(int k=1;k<11;k++){
            Thread memberThread= new Thread(new TeamMember(countDownLatch,k));
            memberThread.start();
        }


    }
}
