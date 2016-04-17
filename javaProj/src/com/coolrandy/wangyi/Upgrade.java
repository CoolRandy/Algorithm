package com.coolrandy.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by randy on 2016/3/18.
 * 在牛客系统上运行部通过，这里运行没问题？？？
 */
public class Upgrade{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        int count = scanner.nextInt();
        if (0 == count){
            System.exit(0);
        }
        int ability = scanner.nextInt();
        if(ability < 1 || ability >= 100000){
            System.exit(0);
        }
        int[] b = new int[count];
        for (int i = 0; i < count; i++){
            b[i] = scanner.nextInt();
            if (ability <= b[i]){
                ability += b[i];
            }else {
                int m = ability, n = b[i];
                int c = 0;
                while (n != 0){
                    c = m % n;
                    m = n;
                    n = c;
                }
                ability += m;
            }
        }
        res.add(ability);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }

    }
}
