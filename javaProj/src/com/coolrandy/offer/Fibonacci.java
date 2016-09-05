package com.coolrandy.offer;


/**
 * Created by randy on 2016/8/30.
 * 斐波那契数列
 *
 * 类似题目：青蛙跳台阶，一次可以跳一级或跳两级
 *
 */
public class Fibonacci {

    public static void main(String[] args){

        long startTime = System.currentTimeMillis();
//        int result = fibonacci_1(30);//result is: 832040, time is: 11
        long result = fibonacci_2(30);//result is: 832040, time is: 0
        long endTime = System.currentTimeMillis();
        System.out.println("result is: " + result + ", time is: " + (endTime - startTime));


    }

    public static int fibonacci_1(int n){

        if (0 == n){
            return 0;
        }

        if (1 == n){
            return 1;
        }

        return fibonacci_1(n-1) + fibonacci_1(n-2);
    }

    public static long fibonacci_2(long n){

        if (0 == n){
            return 0;
        }

        if (1 == n){
            return 1;
        }

        long fibOne = 1;
        long fibTwo = 0;
        long fibN = 0;
        for (long i = 2; i <= n; i++){
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }

}
