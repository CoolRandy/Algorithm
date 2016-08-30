package com.coolrandy.interview;

/**
 * Created by randy on 2016/8/30.
 * 获取矩阵的最小路径和
 * 考察点：动态规划
 */
public class MinPathSum {
    /**
     * 空间复杂度O(M x N)  时间复杂度O(M x N)
     * @param m
     * @return
     */
    public static int minPathSum(int[][] m){

        if (null == m || 0 == m.length || null == m[0] || m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + m[i][0];
        }

        for (int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + m[0][j];
        }

        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }

        return dp[row-1][col-1];
    }

    public static void main(String[] args){
        int array[][] = {
            {3, 5, 12, 21},
            {25, 19, 34, 10},
            {7, 2, 9, 15}
        };
        int result = minPathSum(array);
        System.out.println("min path sum is: " + result);
    }
}
