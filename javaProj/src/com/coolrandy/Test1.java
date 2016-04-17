package com.coolrandy;

import java.util.Scanner;

/**
 * Created by randy on 2016/3/28.
 */
public class Test1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            long n = scanner.nextLong();
            if(n < 1 || n > 300000){
                break;
            }

            long m = scanner.nextLong();
            if(m < 1 || m > 300000){
                break;
            }

            String str = scanner.next();
            if (str.equals("") || str == null){
                break;
            }

            int x = scanner.nextInt();
            byte ch = scanner.nextByte();
            char[] array = str.toCharArray();
            array[x] = (char)ch;

        }
    }
}
