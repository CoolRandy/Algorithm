package com.coolrandy.leetcode.dp;

/**
 * Created by randy on 2016/4/10.
 * 采用动态规划求解最长非降公共子序列
 */
public class LIS_DP {

    public static int dp_lis(int[] a, int n){

        int[] dp = new int[n];
        int length = 1;
        for (int i = 0; i < a.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (a[j] <= a[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > length){
                length = dp[i];
            }
        }

        return length;
    }

    public static void main(String[] args){

        int[] seq = new int[]{5, 3, 4, 8, 6, 7};
        System.out.print(dp_lis(seq, 6));
    }
}
