package com.coolrandy.oj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by randy on 2016/3/27.
 * 始终没有运行通过？？？？
 */
public class AddAll {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            int temp = scanner.nextInt();
            System.out.println(temp * (temp + 1) / 2);
            System.out.print("\n");
        }
    }
}
