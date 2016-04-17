package com.coolrandy.tencent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by randy on 2016/4/1.
 */
public class Gift {

    /**
     *
     * @param gifts  红包金额数组
     * @param n   红包总数
     * @return
     */
    public int getValue(int[] gifts, int n){

        if (0 == n){
            return 0;
        }
        //思路1：采用hashmap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < gifts.length; i++){
            if (hashMap.containsKey(gifts[i])){
                int temp = hashMap.get(gifts[i]);
                temp++;
                hashMap.put(gifts[i], temp);
            }else {
                hashMap.put(gifts[i], 1);
            }
        }
        int res = 0;
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if((Integer)entry.getValue() > (n / 2)){
                res = (Integer)entry.getKey();
            }
        }

        return res;
    }
}
