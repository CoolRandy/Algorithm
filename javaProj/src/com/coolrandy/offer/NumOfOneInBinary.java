package com.coolrandy.offer;

/**
 * Created by randy on 2016/4/17.
 * ������������1�ĸ���
 * ��Ŀ����ʵ��һ������������һ������������ö����Ʊ�ʾ��1�ĸ���
 *
 * ����������������һ������զ�죿���Ի����Ƕ������⣬����ԭʼ��������λ�������ǲ��öԱ�־λ1���в�������
 * �ķ�ʽ��Ȼ��������������ж�1�ĸ���
 *
 * �����Ż��������һ��������1�����ǰ����ұߵ�1��Ϊ0��������ұ߻���0�Ļ������е�0��Ϊ1�������������λ�����ֲ���
 * ��1100Ϊ������1֮���Ϊ1011��Ȼ������������룬���Ϊ1000
 * Ҳ����˵����һ��������ȥ1���ٺ�ԭ���������������㣬�ͻ�Ѹ��������ұߵ�һ��1��Ϊ0��Ҳ����˵һ�������Ķ�����
 * ��ʾ���ж��ٸ�1���ͻ��ж��ٴ������Ĳ���
 *
 * �ܽ᣺һ���ܳ��õĽⷨ˼·����һ��������ȥ1���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱���ǰ������Ķ����Ʊ�ʾ�е�
 * ���ұ�һ��1���0
 *
 */
public class NumOfOneInBinary {

    public static int getNumOfOne(int num){

        //���������λ�ķ�ʽ������Ҫ���������㻻�ɳ������㣬Ч�ʺܵ�
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
     * �ж������Ƿ�Ϊ2��������
     * ������֪�������Ϊ2���������ݣ���ô�����Ʊ�ʾ��ֻ����һλ��1������ȫ����0
     * ����ͬ�����Բ��������һ����ԭ������ķ�ʽ���жϣ�������Ϊ0����ô�ͱ�ʾ�ǵ�
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
     * ������������m��n��������Ҫ�ı�m�Ķ����Ʊ�ʾ�еĶ���λ���ܵõ�n
     * ˼·�����Դ����ĽǶȷ��������λ��ͬ�����Ľ��Ϊ0   λ��ͬ�����Ľ��Ϊ1
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
