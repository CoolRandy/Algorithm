package com.coolrandy.tencent;

import java.util.Scanner;

/**
 * Created by randy on 2016/9/2.
 * 构造回文
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 输出需要删除的字符个数。

 输入描述:

 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.


 输出描述:

 对于每组数据，输出一个整数，代表最少需要删除的字符个数。

 思路有问题，该题需要考虑采用动态规划,实际上就是求解原字符串和反转字符串的最长公共子串问题
 */

//TODO 需要改进代码
public class MakePlalindrome {

    private static int[][] getDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        //注意在求解动态规划表的过程最长公共子串和最长公共子序列是有区别的：
        //对于第0列或第0行，如果str[0..i]最后的str1[i] != str2[0],那么对于公共子串而言考虑到字符位置必须是连续的
        //所以这里的dp[i][0]就是0；  但是对于最长公共序列则是不一样的，就是说如果str1[i] != str2[0]，但是str1[0..i]
        //存在某个位置元素时等于str2[0]的，这样dp[i][0]的值则为1，这点事两者的区别
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //求解第0列
        for (int i = 1; i < str1.length; i++){

            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
        }
        //求解第0行
        for (int j = 1; j < str2.length; j++){

            dp[0][j] = Math.max(dp[0][j-1], str2[j] == str1[0] ? 1 : 0);
        }

        //(i, j)
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

    private static int getPlalindrome(String str){

        StringBuilder builder = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--){
            builder.append(str.charAt(i));
        }
        String reverseStr = builder.toString();
        System.out.println(reverseStr);
        char[] char1 = str.toCharArray();
        char[] char2 = reverseStr.toCharArray();
        int[][] dp = getDp(char1, char2);
        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < reverseStr.length(); j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        int length = dp[char1.length-1][char2.length-1];
        System.out.println("length is: " + length);
        return str.length() - length;
    }

    public static void main(String[] args){

//        String str = "abcda";
//        System.out.println("delete count: " + getPlalindrome(str));

        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str = read.nextLine();
            System.out.println(getPlalindrome(str));
        }
    }
}
