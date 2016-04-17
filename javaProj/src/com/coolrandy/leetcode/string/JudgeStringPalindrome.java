package com.coolrandy.leetcode.string;

import java.util.Stack;

/**
 * Created by randy on 2016/4/9.
 * 判断字符串是否为回文  这里采用了一个栈，空间复杂度为O(N)  时间负责度为O(N)
 */
public class JudgeStringPalindrome {

    public static boolean judgeStringPalindrome(String str1){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str1.length(); i++){
            stack.push(str1.charAt(i));
        }
        int i = 0;
        while (!stack.isEmpty()){

            if (!stack.pop().equals(str1.charAt(i))){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args){
        String str1 = "abdbae";
        System.out.print(judgeStringPalindrome(str1));
    }
}
