package com.lin.callback;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 12/8/2021
 */
public class CallBackDemo {

    public static void main(String[] args) {
        System.out.println("This is the main thread");

        Runnable r = () -> new CallBackDemo().runAsync(new CallBack());
        new Thread(r).start();
        System.out.println("This is the main running......");
        sleep(2000);
        System.out.println("Main thread finished and should also received call back message already");

    }


    public void runAsync(CallBack callback) {
        System.out.println("A new separated thread start now....");

        //simulate thread execution time
        sleep(1000);

        System.out.println("separated thread execution finished! will invoke call back notify the main thread");
        callback.pushData("Data1");
        callback.pushData("Data2");
        callback.pushData("Data3");

        callback.pushError(new RuntimeException("Error!!!1"));
        callback.pushComplete();
    }

    public static void sleep(long millseconds) {
        try {
            Thread.sleep(millseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class CallBack {
        public void pushComplete() {
            System.out.println("Just do it");
        }

        public void pushData(String data) {
            System.out.println("push data:"+data);
        }

        public void pushError(Exception e) {
            System.out.println("error occurs"+e);
        }
    }

}


