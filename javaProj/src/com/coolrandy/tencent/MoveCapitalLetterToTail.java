package com.coolrandy.tencent;
import java.util.Scanner;

/**
 * Created by randy on 2016/9/4.
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 */
public class MoveCapitalLetterToTail {

    private static String moveCapitalLetterToTail(String str) {

        char[] chars = str.toCharArray();
        CharClass charClass;
        int len = chars.length;
        int end = len;
        for (int i = 0; i < end; ++i) {
            if (isCap(chars[i])) {
                int j = i;
                for (; j < len - 1; ++j) {
                    swap(j, j + 1, chars);
                }
                --end;
                --i;
            }
        }

        return new String(chars);
    }


    private static boolean isCap(char c)
    {
        if (c >= 'A' && c <= 'Z')
            return true;
        else
            return false;
    }

    private static void swap(int index1, int index2, char[] chars){

        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;

    }

    private static class CharClass{
        char char1;
        char char2;

        public CharClass(char char1, char char2) {
            this.char1 = char1;
            this.char2 = char2;
        }
    }

    public static void main(String[] args){
//        String str = "wdrfADroijGde";
//        System.out.println("result is: " + moveCapitalLetterToTail(str));

        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str = read.nextLine();
            if (str.length() < 1 || str.length() > 1000){
                break;
            }
            System.out.println(moveCapitalLetterToTail(str));
        }
    }
}
