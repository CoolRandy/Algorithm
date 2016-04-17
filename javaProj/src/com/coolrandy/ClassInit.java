package com.coolrandy;

/**
 * Created by randy on 2016/4/14.
 *
 */
public class ClassInit {

    private int myId1;
    private int myId2 = 100;
    //非静态代码块
    {
        print();
        myText1 = "text1-0";
    }

    private String myText1 = "text1-1";
    private String myText2 = null;
    //显示构造方法
    public ClassInit() {
        print();
        myId1 = 100;
        myText1 = "text1-0";
        myText2 = new String("text2");
    }

    public void print(){
        System.out.println("text: " + myText1);
    }

    public static void main(String[] args){

        ClassInit classInit = new ClassInit();
    }

}
