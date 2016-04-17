package com.coolrandy.leetcode.string;

/**
 * Created by randy on 2016/4/9.
 * 将字符串转换成整型
 */

//TODO 需完善。。。
public class ChangeStringToInt {

    public static int changeStringToInt(String str){

        if (null == str || str.equals("")){
            return -1;
        }
        int num = 0;
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return -1;
            }

            num = num * 10 + str.charAt(i) - '0';
        }

        return num;
    }
}
