package com.coolrandy.offer;

import java.math.BigDecimal;

/**
 * Created by randy on 2016/4/17.
 * ��Ŀ������ʵ�ֺ���double Power(double base, int exponent),��base��exponent�η�
 * Ҫ�󣺲���ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ�������
 *
 * ����Ĺؼ���Ҫ�����һЩ�����������Ϊ0��ָ��Ϊ������  0��0�η�����ѧ��û�����壬�������0����1�����Խ���
 */
public class NumPower_11 {
    /**
     * �÷������õĽⷨ���������ˣ���Ҫ����exponent-1���������
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent){

//        if (0 == base && exponent < 0){//���ﴦ���е����⣬base��double���ͣ�����ֱ���õȺűȽϴ�С
//        if (equal(base, 0.0) && exponent < 0){
        BigDecimal bigDecimal = new BigDecimal(base);
        BigDecimal bigDecimal1 = new BigDecimal(0.0);
        if (bigDecimal.compareTo(bigDecimal1) == 0  && exponent < 0){
            throw new IllegalStateException("0 cannot be denominator");
        }

        double res = 1.0;
        for (int i = 1; i <= Math.abs(exponent); i++){
            res *= base;
        }

        if (exponent < 0){
            res = 1 / res;
        }

        return res;
    }
    /**
     * ����2�����ù�ʽ�ֽ�   a^n = a^(n/2) * a^(n/2)  nΪż��
     *                           a^((n-1)/2) * a((n-1)/2) * a  n Ϊ����
     *  ������Щ������������Ҫ֪������������Ʊ�ʾ���һλΪ1�����Ӧ��ʮ������Ϊ�����������һλΪ0�� ����ż��
     *  ������������������ж���ż�ԡ�
     *  ��������Ĺ�ʽ���������뵽�ݹ����
     *
     *  ���ֲ��ù�ʽ����ķ�ʽ�����Կ������˷�
     */
    public static double Power_1(double base, int exponent){
        //������ʱû�п����쳣����
        if (0 == exponent){
            return 1;
        }
        if (1 == exponent){
            return base;
        }

        double result = Power_1(base, exponent >> 1);//��������һλ�����������
        result *= result;
        if ((exponent & 0x1) == 1){//�������������ж���ż
            result *= base;
        }

        return result;
    }

    /**
     * ���ִ������Cʵ�֣���java�бȽ�double���ͣ�һ�㽫�����ΪBigDecimal���󣬵���compareTo�������бȽ�
     * �ж�����С���Ƿ���ȣ�ֻ���ж�����֮��ľ���ֵ�Ƿ���һ����С�ķ�Χ��
     * @param n1
     * @param n2
     * @return
     */
    private static boolean equal(double n1, double n2){
        if ((n1 - n2 > -0.0000001) && (n1 - n2 < 0.0000001)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){

        System.out.println(Power(3, 4));
        System.out.println(Power(0, 2));
//        System.out.println(Power(0, -2));

        System.out.println(Power_1(3, 4));
        System.out.println(Power_1(3, 5));
    }
}
