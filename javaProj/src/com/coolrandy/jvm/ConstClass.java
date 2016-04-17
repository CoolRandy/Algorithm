package com.coolrandy.jvm;

/**
 * Created by randy on 2016/3/10.
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}
