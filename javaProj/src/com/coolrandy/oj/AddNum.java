package com.coolrandy.oj;

import java.util.Scanner;

/**
 * Created by randy on 2016/3/27.
 * A+B����
 */
public class AddNum {

    public static void main(String[] args){
        int a, b;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println(a + b);
        }

    }
}
