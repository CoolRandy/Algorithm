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

    /**
     * 对矩阵空间进行压缩
     * 原始矩阵：
     * 1  3  5  9
     * 8  1  3  4
     * 5  0  6  1
     * 8  8  4  0
     * 思路描述：
     * 首先分为两种情况1、行数不小于列数  2、行数小于列数  两种情况类似，只分析情况1
     * 首先初始化arr = [dp[0][0], dp[0][1], dp[0][2], dp[0][3]] = [1, 4, 8, 18]
     * 然后更新arr，遍历到第二行dp[1][0] = dp[0][0] + m[1][0] = 1 + 8 = 9
     * 更新arr[0] = dp[1][0] = 9,  arr[1] = min{dp[0][1], dp[1][0]} + m[1][1] = min{arr[1], arr[0]} + 1
     * 此时arr[1]还是原来的值即dp[0][1] = 4, 而arr[0]已经更新为dp[1][0] = 9, 则更新后arr[1] = 4 + 1 = 5
     * 依次类推最终得到arr = [9, 5, 8, 12]
     *
     * 然后接下来继续遍历第三行，直到最后一行为止
     * 该改进算法时间复杂度没变，但是空间复杂度减小为min{M, N}
     * @param m
     * @return
     */
    public static int minPathSum_1(int[][] m){

        if (null == m || 0 == m.length || null == m[0] || m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
//        int[][] dp = new int[row][col];
//        dp[0][0] = m[0][0];

        if (row >= col){
            int[] arr = new int[col];
            arr[0] = m[0][0];//初始化
            for (int i = 1; i < col; i++){
                arr[i] = arr[i - 1] + m[0][i];
            }

            for (int i = 1; i < row; i++){
                arr[0] = arr[0] + m[i][0];
                for (int j = 1; j < col; j++){
                    arr[j] = Math.min(arr[j-1], arr[j]) + m[i][j];
                }
            }

            return arr[col-1];
        }else {
            int[] arr = new int[row];
            arr[0] = m[0][0];//初始化
            for (int i = 1; i < row; i++){
                arr[i] = arr[i - 1] + m[i][0];
            }

            for (int i = 1; i < col; i++){
                arr[0] = arr[0] + m[0][i];
                for (int j = 1; j < row; j++){
                    arr[j] = Math.min(arr[j-1], arr[j]) + m[j][i];
                }
            }

            return arr[row-1];
        }

    }

    public static void main(String[] args){
        int array[][] = {
            {3, 5, 12, 21},
            {25, 19, 34, 10},
            {7, 2, 9, 15}
        };
        int result = minPathSum_1(array);
        System.out.println("min path sum is: " + result);
    }
}
