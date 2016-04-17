package com.coolrandy.leetcode.string;

import java.util.Stack;

/**
 * Created by randy on 2016/4/9.
 * �ж��ַ����Ƿ�Ϊ����  ���������һ��ջ���ռ临�Ӷ�ΪO(N)  ʱ�为���ΪO(N)
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
