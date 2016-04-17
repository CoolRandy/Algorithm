package com.coolrandy.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by randy on 2016/3/12.
 */
public class StopThread {
    //代码可能出现的结果就是由于没有同步，就不能保证后台线程何时能够看到主线程对于stopRequested值的修改
    //修正方案：同步访问stopRequested域
    private static boolean stopRequested;

    //添加同步处理
    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException{


        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {

                int i = 0;
                while (!stopRequested()){
                    i++;
                    System.out.println("i = " + i);
                }
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
//        stopRequested = true;
        requestStop();

    }
}
