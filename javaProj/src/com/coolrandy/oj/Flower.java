package com.coolrandy.oj;

import java.util.Scanner;

/**
 * Created by randy on 2016/3/27.
 * 水仙花问题
 */
public class Flower {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int a = scanner.nextInt();
            if(a < 100 || a > 999){
                break;
            }

            int b = scanner.nextInt();
            if (b < 100 || b > 999){
                break;
            }
            boolean has = false;
            int min = a > b? b : a;
            int max = a > b? a : b;
            for (int i = min; i <= max; i++){
                int _b = i / 100;
                int _s = i % 100 / 10;
                int _g = i % 10;

                if(i == Math.pow(_b, 3) + Math.pow(_s, 3) + Math.pow(_g, 3)){
                    System.out.print(i + " ");
                    has = true;
                }
            }
            if(!has){
                System.out.println("no");
            }
        }
    }
}
