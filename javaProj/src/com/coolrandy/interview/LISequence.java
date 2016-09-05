package com.coolrandy.interview;

import sun.java2d.pipe.AAShapePipe;

import javax.swing.*;

/**
 * Created by randy on 2016/8/31.
 * 求解最长递增子序列
 */
public class LISequence {

    /**
     * 获取dp数组
     * @param arr
     * @return
     * 时间复杂度为O(N x N)
     */
    public static int[] getDp(int[] arr){

        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            //初始化第一个dp数组最大递增子序列长度为1
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * 根据原始数组和dp数组，回溯查找最长递增子序列
     * @param arr
     * @param dp
     * @return
     */
    public static int[] getLIS(int[] arr, int[] dp){

        //1、先找出dp数组中最大的值以及索引
        int max = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++){
            if (dp[i] > max){
                max = dp[i];//最大的值
                index = i;
            }
        }
        int[] result = new int[max];
        result[--max] = arr[index];
        //2、从右向左回溯遍历查找满足以下两个条件的元素：dp[i] = dp[i-1] + 1  且  arr[i] < arr[index]
        for (int j = index - 1; j >= 0; j--){
            if (arr[j] < arr[index] && (dp[index] == dp[j] + 1)){
                result[--max] = arr[j];
                index = j;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] dp = getDp(arr);
        for (int i = 0; i < dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println(" ");
        int[] result = getLIS(arr,dp);
        for (int res: result){
            System.out.print(res + " ");
        }
    }
}
