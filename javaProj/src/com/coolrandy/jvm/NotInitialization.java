package com.coolrandy.jvm;

/**
 * Created by randy on 2016/3/10.
 * ��ʾ1��
 * �ô���ֻ�����SuperClass init!���������SubClass init!
 * ��Ϊ���ھ�̬�ֶΣ�ֻ��ֱ�Ӷ�����ֶε���Żᱻ��ʼ�������ͨ�������������ø�����
 * ����ľ�̬�ֶΣ�ֻ�ᴥ������ĳ�ʼ�������ᴥ������ĳ�ʼ��
 * ��ʾ2��
 * ͨ�����鶨���������࣬���ᴥ������ĳ�ʼ��
 * ��ʾ3��
 * �����ڱ���׶λ����������еĳ������У�������û��ֱ�����õ����峣�����࣬��˲��ᴥ�����峣������ĳ�ʼ��
 *
 */
public class NotInitialization {

    public static void main(String[] args){
        //��ʾ1��
//        System.out.println(SubClass.value);

        //��ʾ2�� û�����
//        SuperClass[] sca = new SuperClass[10];

        //��ʾ3��û�����ConstClass init!
        System.out.println(ConstClass.HELLOWORLD);
    }
}
