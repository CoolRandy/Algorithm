package com.coolrandy.oj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by randy on 2016/3/27.
 * 数列求和
 */
public class ShuLieSum {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int n = scanner.nextInt();
            if(n >= 10000 || n < 0){
                break;
            }

            int m = scanner.nextInt();
            if (m >= 1000 || m <= 0){
                break;
            }
            double sum = 0;
            double temp = n;
            for (int i = 1; i <= m; i++){

                sum = sum + temp;
                temp = Math.sqrt(temp);
            }
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(sum));
        }
    }
}
