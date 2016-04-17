package com.coolrandy.offer;

/**
 * Created by randy on 2016/4/2.
 * 用%20替换字符串中的空格
 */
public class ReplaceBlank_2 {

    public static String replaceBlank(String str){

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++){

            if (str.charAt(i) == ' '){
                builder.append("%20");
            }else {
                builder.append(str.charAt(i));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args){

        String string = "we are family";
        System.out.print(replaceBlank(string));
    }
}
