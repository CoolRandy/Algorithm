package com.coolrandy.leetcode.dp;

/**
 * Created by randy on 2016/4/10.
 * ���ö�̬�滮��Ӳ�ҵ�����
 * �����������ֵΪ1Ԫ��3Ԫ��5Ԫ��Ӳ������ö����������ٵ�Ӳ�Ҵչ�11Ԫ��
 * ˼·���Բο� http://hawstein.com/posts/dp-novice-to-advanced.html
 * d[i] = min{ d[ i - coin[j] ] + 1}  ����coin[j]��ʾ��j��Ӳ�ҵ���ֵ
 * �൱��״̬ת�Ʒ���  dp[i] = min(dp[i-C1]+1,dp[i-C2]+1,dp[i-C3]+1,����,dp[i-Cj]+1])
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
            System.out.println("����" + i + "Ԫ�� ������Ҫ" + dp[i] + "öӲ��");
        }
    }
}
/**
 * ���ڶ�̬�滮�����޺�Ч�ԣ�Ҳ����˵�󲿷�����£�ĳ��״ֻ̬����ǰ���״̬�йأ��������ں����״̬
 * ����һ����ǵݼ�����������������ҵ�״̬��״̬ת�Ʒ��̵ģ�
 * ���翼����A[1],A[2],��,A[i]����ǽ������еĳ��ȣ�����i<N  �����ԭ���⣺һ��������N������A[1],A[2],��,A[N]�������ǽ������еĳ��ȡ�
 * ������һ��������  �����ģ��С��  �����Ϳ��Դ�i= 1, 2, 3..������
 * �������������Ӳ���������ƣ�����һ��d(i), ��ʾǰi��������A[i]��β����ǽ������еĳ���
 * ���Բ��뵽�����d(i)����Ҫ�ҵ�״̬   ������������״̬ת�Ʒ�����
 * �������Ҫ�����N�����������ǣ�5��3��4��8��6��7
 * ���������ҵ���״̬�����ǿ��Եõ��������ĵ���ǽ������ж���LIS��ʾ��
 * ǰ1������LIS����d(1)=1(���У�5)
 * ǰ2������LIS����d(2)=1(���У�3��3ǰ��û�б�3С��)
 * ǰ3������LIS����d(3)=2(���У�3��4��4ǰ���и�����С��3������d(3)=d(2)+1)
 * ǰ4������LIS����d(4)=3(���У�3��4��8��8ǰ�����С����3���������� d(4)=max{d(1),d(2),d(3)}+1=3)
 *
 * ��������Ѿ������d(1)��d(i-1)�� ��ôd(i)�����������״̬ת�Ʒ��̵õ���
 * d(i) = max{1, d(j)+1},����j<i,A[j]<=A[i]
 */


























