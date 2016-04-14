package com.coolrandy.offer;

/**
 * Created by admin on 2016/4/14.
 * 斐波那契数列  对传统递归算法的优化  思想就是：把已得到的数列中间项保留起来，下次计算之前先查找一下
 * 从下往上计算  时间复杂度为O（n    ）
 */
public class Fibonacci {

    public static long fibonacci(int n){

        int[] result = new int[]{0,1};
        if (n < 2){
            return result[n];
        }

        long fibOne = 1;
        long finTwo = 0;
        long fibN = 0;

        for (int i = 2; i < n; i++){

            fibN = fibOne + finTwo;

            fibOne = fibN;
            finTwo = fibOne;
        }

        return fibN;
    }

    public static void main(String[] args){

        System.out.print(fibonacci(20));
    }
}
