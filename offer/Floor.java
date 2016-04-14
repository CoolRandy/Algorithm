package com.coolrandy.offer;

/**
 * Created by admin on 2016/4/14.
 * 青蛙跳阶问题 实际上就是斐波那契数列
 * 如何理解呢？可以把n级台阶的跳法看成是n的函数，记为f(n)  当n>2时，第一次跳就有两种选择，一是第一次跳一级，那么后面跳的级数就是f(n-1)
 * 另外一种情况就是：第一次跳两级，那么后面跳的级数就是f(n-2),这样n级不同的跳法就有f(n-1)+f(n-2)
 */
public class Floor {

    public static long floor(int n){

        if (0 == n){
            return 0;
        }
        if (1 == n){
            return 1;
        }
        if (2 == n){
            return 2;
        }
        return floor(n-1) + floor(n-2);
    }

    public static void main(String[] args){

        System.out.print(floor(4));
    }
}
