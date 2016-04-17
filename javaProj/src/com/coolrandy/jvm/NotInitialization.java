package com.coolrandy.jvm;

/**
 * Created by randy on 2016/3/10.
 * 演示1：
 * 该代码只会输出SuperClass init!而不会输出SubClass init!
 * 因为对于静态字段，只有直接定义该字段的类才会被初始化，因此通过其子类来引用父类中
 * 定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
 * 演示2：
 * 通过数组定义来引用类，不会触发此类的初始化
 * 演示3：
 * 常量在编译阶段会存入调用类中的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 *
 */
public class NotInitialization {

    public static void main(String[] args){
        //演示1：
//        System.out.println(SubClass.value);

        //演示2： 没有输出
//        SuperClass[] sca = new SuperClass[10];

        //演示3：没有输出ConstClass init!
        System.out.println(ConstClass.HELLOWORLD);
    }
}
