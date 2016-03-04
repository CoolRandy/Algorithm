package com.coolrandy;

import javax.swing.*;

/**
 * Created by randy on 2016/3/4.
 */
public class BinarySearch {

    /**
     * 迭代实现
     * 当right取n-1时，while循环条件需设置为<=而不是<号，需注意
     * left + ((right - left)>>1)这一块采用位移的方式处理，而不是(right + left)/2，考虑到当数据过大，直接求和可能会溢出
     * 此外后面最外层的括号需保留
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearch(int a[], int n, int value){

        int left = 0;
        int right = n - 1;
        while (left <= right){
            int middle = left + ((right - left)>>1);
            if(a[middle] > value){
                right = middle - 1;
            }else if(a[middle] < value){
                left = middle + 1;
            }else {
                return middle;
            }
        }

        return -1;
    }

    /**
     * 递归实现
     * @param a
     * @param value
     * @param start
     * @param end
     * @return
     */
    public static int recurBinarySearch(int a[], int value, int start, int end){

        if(start > end){
            return -1;
        }

        int middle = start + ((end - start)>>1);
//        int middle = (start + end) / 2;
        if(value > a[middle]){
            return recurBinarySearch(a, value, middle+1, end);
        }
        if(value < a[middle]){
           return recurBinarySearch(a, value, start, middle-1);
        }
        return middle;
    }

    public static int findIndex(int a[], int target){
        return recurBinarySearch(a, target, 0, a.length - 1);
    }


    public static void main(String[] args){

        boolean isRcursion = false;

        int[] a = new int[]{1, 4, 6, 7, 12, 13, 15, 18, 19, 20, 22, 24};

        int res;
        if(isRcursion){
            res = findIndex(a, 20);
        }else {
            res = binarySearch(a, a.length, 20);
        }


        System.out.print("res: " + res);
    }
}
