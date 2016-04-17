package com.coolrandy.offer;

/**
 * Created by randy on 2016/4/17.
 * 求解二进制数中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该二进制表示中1的个数
 *
 * 升级：如果输入的是一个负数咋办？可以换个角度想问题，不对原始整数做移位处理，而是采用对标志位1进行不断左移
 * 的方式，然后跟整数相与来判断1的个数
 *
 * 继续优化：如果把一个整数减1，都是把最右边的1变为0，如果它右边还有0的话，所有的0变为1，而它左边所有位都保持不变
 * 以1100为例，减1之后变为1011，然后把两个数相与，结果为1000
 * 也即是说：把一个整数减去1，再和原来的整数做与运算，就会把该整数最右边的一个1变为0，也就是说一个整数的二进制
 * 表示中有多少个1，就会有多少次这样的操作
 *
 * 总结：一个很常用的解法思路：把一个整数减去1后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的
 * 最右边一个1变成0
 *
 */
public class NumOfOneInBinary {

    public static int getNumOfOne(int num){

        //这里采用移位的方式处理，不要讲右移运算换成除法运算，效率很低
        int count = 0;
        int flag = 1;
        if (num >= 0) {
            while (num != 0) {
                if ((num & 1) != 0) {
                    count++;
                }
                num = num >> 1;
            }
        }else {

            while (flag != 0){
                if ((flag & num) != 0) {
                    count++;
                }
                flag = flag << 1;
            }
        }
        return count;
    }

    public static int getNumOfOneProv(int num){

        int count = 0;
        while (num != 0){
            ++count;
            num = (num-1) & num;
        }
        return count;
    }

    /**
     * 判断整数是否为2的整数幂
     * 分析可知如果整数为2的整数次幂，那么二进制表示中只包含一位是1，其余全部是0
     * 所以同样可以采用上面减一并与原数相与的方式来判断，如果结果为0，那么就表示是的
     * @param num
     * @return
     */
    public static boolean judgeIsTwoOrNot(int num){

        if (0 == ((num - 1) & num)){
            return true;
        }
        return false;
    }

    /**
     * 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
     * 思路：可以从异或的角度分析，如果位相同，异或的结果为0   位不同，异或的结果为1
     * @param m
     * @param n
     * @return
     */
    public static int changeMToN(int m, int n){

        int flag = 1;
        int count = 0;
        while (flag != 0){

            int tempM = flag & m;
            int tempN = flag & n;
            if ((tempM ^ tempN) != 0){
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }


    public static void main(String[] args){

        System.out.println("the number of 1 is: " + getNumOfOneProv(12));

        System.out.println("judge num: " + judgeIsTwoOrNot(12));

        System.out.println("change m to n needs: " + changeMToN(13, 3));
    }
}
