package com.coolrandy.interview;


/**
 * Created by randy on 2016/9/4.
 * 求解最长公共子串
 */
public class LongestCommonSubString {
    /**
     * 获取动态规划表
     * @param str1
     * @param str2
     * @return
     */
    private static int[][] getDp(char[] str1, char[] str2){

        int m = str1.length;
        int n = str2.length;
        int[][] dp = new int[m][n];
        //第0行
        for (int i = 0; i < m; i++){
            if (str1[i] == str2[0]){
                dp[i][0] = 1;
            }
        }
        //第0列
        for (int j = 0; j < n; j++){
            if (str2[j] == str1[0]){
                dp[0][j] = 1;
            }
        }

        //(i, j)
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (str1[i] != str2[j]){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp;
    }

    /**
     *          b  e  b  c  d
     *        a 0  0  0  0  0
     *        b 1  0  1  0  0
     *        c 0  0  0  2  0
     *        d 0  0  0  0  3
     *        e 0  1  0  0  0
     *        可以看到最长子串长度为3， str1[3],str2[4], 由长度以及最后的位置可以确定，子串遍历开始于str1[1..3]
     *        str2[2..4]
     * @param str1
     * @param str2
     * @return
     */

    private static String lcst(String str1, String str2){

        if (null == str1 || null == str2 || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] dp = getDp(char1, char2);
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        int max = 0;
        int end = 0;
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                if (max < dp[i][j]){
                    max = dp[i][j];
                    end = i;
                }
            }
        }

        return str1.substring(end-max+1, end + 1);
    }

    public static void main(String[] args){

        String str1 = "1ab2345cd";
        String str2 = "12345ef";
        System.out.println("result is: " + lcst(str1, str2));
    }
}
