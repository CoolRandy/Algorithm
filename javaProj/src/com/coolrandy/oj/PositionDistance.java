package com.coolrandy.oj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by randy on 2016/3/27.
 */
public class PositionDistance {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double temp = (double)Math.sqrt((double)(x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(temp));
        }
    }
}
