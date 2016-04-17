package com.coolrandy.offer;

import java.math.BigDecimal;

/**
 * Created by randy on 2016/4/17.
 * 题目描述：实现函数double Power(double base, int exponent),求base的exponent次方
 * 要求：不得使用库函数，同时不需要考虑大数问题
 *
 * 这里的关键是要处理好一些特殊情况：底为0，指数为负数等  0的0次方在数学上没有意义，所以输出0或者1都可以接受
 */
public class NumPower_11 {
    /**
     * 该方法采用的解法就是逐个相乘，需要进行exponent-1次相乘运算
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent){

//        if (0 == base && exponent < 0){//这里处理有点问题，base是double类型，不能直接用等号比较大小
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
     * 方法2：采用公式分解   a^n = a^(n/2) * a^(n/2)  n为偶数
     *                           a^((n-1)/2) * a((n-1)/2) * a  n 为奇数
     *  这里有些二进制特性需要知道：如果二进制表示最后一位为1，则对应的十进制数为奇数；若最后一位为0， 则是偶数
     *  可以利用这个特性来判断奇偶性。
     *  利用上面的公式很容易联想到递归调用
     *
     *  这种采用公式处理的方式即可以快速做乘方
     */
    public static double Power_1(double base, int exponent){
        //这里暂时没有考虑异常条件
        if (0 == exponent){
            return 1;
        }
        if (1 == exponent){
            return base;
        }

        double result = Power_1(base, exponent >> 1);//采用右移一位代替除法运算
        result *= result;
        if ((exponent & 0x1) == 1){//采用相与运算判断奇偶
            result *= base;
        }

        return result;
    }

    /**
     * 这种处理针对C实现，在java中比较double类型，一般将其包裹为BigDecimal对象，调用compareTo方法进行比较
     * 判断两个小数是否相等，只能判断他们之差的绝对值是否在一个很小的范围内
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
