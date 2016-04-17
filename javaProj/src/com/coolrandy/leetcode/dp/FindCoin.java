package com.coolrandy.leetcode.dp;

/**
 * Created by randy on 2016/4/10.
 * 采用动态规划凑硬币的问题
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * 思路可以参考 http://hawstein.com/posts/dp-novice-to-advanced.html
 * d[i] = min{ d[ i - coin[j] ] + 1}  其中coin[j]表示第j个硬币的面值
 * 相当于状态转移方程  dp[i] = min(dp[i-C1]+1,dp[i-C2]+1,dp[i-C3]+1,……,dp[i-Cj]+1])
 */
public class FindCoin {

    public static int min(int a, int b){

        return a < b? a : b;
    }
    static int[] coin = new int[]{1, 3, 5};
    static int[] dp = new int[12];

    public static void dp_find(int i, int num){

        if (0 == i){
            dp[i] = 0;
            dp_find(1, num);
            return;
        }else {

            int MIN = Integer.MAX_VALUE;
            for (int j = 0; j < coin.length; j++){
                if (i >= coin[j]){
                    MIN = min(dp[i - coin[j]] + 1, MIN);
                }
            }

            dp[i] = MIN;
            if (i == num){
                return;
            }else {
                dp_find(i+1, num);
            }
        }
    }

    public static void main(String[] args){

        dp_find(0, 11);
        for (int i = 0; i <= 11; i++){
            System.out.println("凑齐" + i + "元， 至少需要" + dp[i] + "枚硬币");
        }
    }
}
/**
 * 关于动态规划具有无后效性，也就是说大部分情况下，某个状态只与它前面的状态有关，而独立于后面的状态
 * 分析一下最长非递减公共子序列是如何找到状态和状态转移方程的？
 * 假如考虑求A[1],A[2],…,A[i]的最长非降子序列的长度，其中i<N  则对于原问题：一个序列有N个数：A[1],A[2],…,A[N]，求出最长非降子序列的长度。
 * 则变成了一个子问题  问题规模变小了  这样就可以从i= 1, 2, 3..来分析
 * 不妨和上面的求硬币问题类似，定义一个d(i), 表示前i个数中以A[i]结尾的最长非降子序列的长度
 * 可以猜想到这里的d(i)就是要找的状态   接下来就是找状态转移方程了
 * 如果我们要求的这N个数的序列是：5，3，4，8，6，7
 * 根据上面找到的状态，我们可以得到：（下文的最长非降子序列都用LIS表示）
 * 前1个数的LIS长度d(1)=1(序列：5)
 * 前2个数的LIS长度d(2)=1(序列：3；3前面没有比3小的)
 * 前3个数的LIS长度d(3)=2(序列：3，4；4前面有个比它小的3，所以d(3)=d(2)+1)
 * 前4个数的LIS长度d(4)=3(序列：3，4，8；8前面比它小的有3个数，所以 d(4)=max{d(1),d(2),d(3)}+1=3)
 *
 * 如果我们已经求出了d(1)到d(i-1)， 那么d(i)可以用下面的状态转移方程得到：
 * d(i) = max{1, d(j)+1},其中j<i,A[j]<=A[i]
 */


























