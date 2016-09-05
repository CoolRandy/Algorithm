package com.coolrandy.offer;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;

/**
 * Created by randy on 2016/9/5.
 * 面试题14.调整数组的顺序使得奇数位于偶数前面
 */
public class SwitchOddAndEven {

    private static boolean isEven(int ele){
        //判断是否为偶数
        return (ele & 1) == 0;
    }
    private static int[] switchOddWithEven(int[] arr){

        int begin = 0;
        int end = arr.length - 1;

        while (begin < end){

            while (begin < end && isEven(arr[end])){
                --end;
            }

            while (begin < end && !isEven(arr[begin])){
                ++begin;
            }

            if (begin < end){
//                swap(arr[begin], arr[end]);//必须是引用交换
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }

        return arr;
    }

    public static void swap(int a, int b){

        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args){
        int[] a = {2, 3, 9, 4, 2, 8, 15, 17, 6};
        int[] result = switchOddWithEven(a);
        for (int ele: result){
            System.out.print(ele + " ");
        }
    }
}
