package com.coolrandy.tencent;

/**
 * Created by randy on 2016/4/1.
 */
public class GrayCode {

    public String[] getGray(int n){

        String[] res = new String[(int)Math.pow(2, n)];

        if (1 == n){

            res[0] = "0";
            res[1] = "1";
            return res;
        }

        String[] last = getGray(n-1);
        for (int i = 0; i < last.length; i++){
            res[i] = "0" + last[i];
            res[res.length - i - 1] = "1" + last[i];
        }

        return res;
    }
}
