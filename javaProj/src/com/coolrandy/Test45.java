package com.coolrandy;

import java.util.ArrayList;

/**
 * Created by randy on 2016/4/6.
 *
 */
public class Test45 {

    public void Solution(int num){

        if (0 == num){
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
       while (i < num){
            if(num % i == 0){
                num = num / i;
                arrayList.add(i);
                i++;
            }
        }
        arrayList.add(num);

        for (int j = 0; j < arrayList.size(); j++){
            System.out.print(arrayList.get(j) + " ");
        }

    }
}
