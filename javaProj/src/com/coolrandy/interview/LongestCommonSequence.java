package com.coolrandy.interview;

/**
 * Created by randy on 2016/9/4.
 * 求解最长公共子序列
 * 注意最长公共子序列和最长公共子串的区别：子序列不要求字符的位置是连续的，子串要求字符的位置必须是连续的
 */
public class LongestCommonSequence {

    private static int[][] getDp(char[] str1, char[] str2){

        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for (int i = 1; i < str1.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
        }

        for (int i = 1; i < str2.length; i++){
            dp[0][i] = Math.max(dp[0][i-1], str1[0] == str2[i] ? 1 : 0);
        }

        for (int i = 1; i < str1.length; i++){
            for (int j = 1; j < str2.length; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }

        return dp;
    }

    public static String lcse(String str1, String str2){

        if (null == str1 || null == str2 || str1.equals("") || str2.equals("")){
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int[][] dp = getDp(chs1, chs2);
        int m = chs1.length - 1;
        int n = chs2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0){
            if (n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            }else if (m > 0 && dp[m][n] == dp[m-1][n]){
                m--;
            }else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args){

        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";

        String result = lcse(str1, str2);
        System.out.println("result is: " + result);
    }

}
