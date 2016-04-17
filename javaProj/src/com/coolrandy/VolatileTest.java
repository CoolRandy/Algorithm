package com.coolrandy;

/**
 * Created by randy on 2016/3/13.
 *
 * 对于volatile的测试理解：
 * 这段代码发起了20个线程，每个线程对race变量进行10000次自增操作，如果该代码可以正常并发执行
 * 最后的结果应该是200000，但是实际运行会发现每次运行的结果都不是200000，而是略小于该值
 * 问题就出在自增运算“race++”上，
 */
public class VolatileTest {

    public static volatile int race = 0;
    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args){

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0; i < 10000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
            System.out.println(race);
        }
    }
}
