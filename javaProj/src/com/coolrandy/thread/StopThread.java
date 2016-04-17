package com.coolrandy.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by randy on 2016/3/12.
 */
public class StopThread {
    //������ܳ��ֵĽ����������û��ͬ�����Ͳ��ܱ�֤��̨�̺߳�ʱ�ܹ��������̶߳���stopRequestedֵ���޸�
    //����������ͬ������stopRequested��
    private static boolean stopRequested;

    //���ͬ������
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
