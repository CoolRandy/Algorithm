package com.coolrandy;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by randy on 2016/3/28.
 */
public class Test {

    public static void main(String[] args){



        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int n = scanner.nextInt();
            if(n > Math.pow(10, 9) || n < 1){
                break;
            }

            int b = scanner.nextInt();
            if(b > n || b < 1){
                break;
            }
            System.out.println("n= " + n + ", b= " + b);
            Random random = new Random();
            int randNum = random.nextInt(n) + 1;
            System.out.println(randNum);
            int dis = Math.abs(b - randNum);
            System.out.println(dis);
            int count = 0;
            int max = 0;
            int res = 0;

            if (b > randNum){
                if(Math.abs(b - randNum) < Math.abs(b - n)){

                }
            }


            for (int i = 1; i <= n; i++){
                if(Math.abs(i - n) > dis){
                    count++;
                    if(Math.abs(i-n) > max){
                        max = Math.abs(i-n);
                        res = i;
                    }
                }else if(Math.abs(i-n) == dis){
                    res = dis;
                }
            }

            System.out.print(res);

        }
    }
}
