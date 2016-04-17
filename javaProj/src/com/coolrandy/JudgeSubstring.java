package com.coolrandy;

import javax.swing.text.StyledEditorKit;

/**
 * Created by randy on 2016/3/4.
 * 判断一个字符串是否为另一个字符串的子串
 * 分析可知该算法最坏时间复杂度为O(mn)  最好时间复杂度为O(n)
 * 这里采用的是暴力匹配算法，可以采用KMP匹配算法优化
 */
public class JudgeSubstring {

    public static boolean isSubstring(String str1, String str2){

        int str1Length = str1.length();
        int str2Length = str2.length();
        int i = 0;
        int j = 0;
        while (i < str1Length) {
            while(j < str2Length) {
                if (str2.charAt(j) != str1.charAt(i)) {
                    j = j - (i - 1);//需要往前回溯
                    i = 0;
//                    j++;
                    if(j >= str2Length-1){
                        return false;
                    }
                    break;
                } else {
                    if(i >= str1Length-1) {
                        return true;
                    }
                    i++;
                    j++;
                }
            }
        }
        if(j >= str2Length){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args){
        String s1 = "abcsdrsdfertg";
        String s2 = "sdf";
        String s3 = "rty";

        boolean res1 = isSubstring(s2, s1);
        boolean res2 = isSubstring(s3, s1);
        System.out.print("result: " + res1 + ", " + res2);
    }
}
