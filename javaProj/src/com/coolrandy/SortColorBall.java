package com.coolrandy;

/**
 * Created by randy on 2016/3/19.
 * ��Ŀ����������һ���������������ɫ���򣬷ֱ�Ϊ�졢�ס�����Ϊ�����ʾ�ֱ�������0��1��2���б�ʾ��˳���Ǵ��ҵ�
 * ��Ҫ�������򣬽���ͬ��ɫ����ŵ�һ�𣬰��պ������˳��
 * ʵ���ϸ�������Ǻ�����������
 */
public class SortColorBall {

    /**
     * �˷�����˼·�ǲ����½�һ������temp�ֱ���rwb������ɫ����������ʼֵΪ0
     * Ȼ�����Ƚ��������ź���ͬʱ���������������������ŵ�temp�����Ӧ���±���
     * �Ⱥ����ź���֮�����ΰ��հ����������������и�ֵ�����������������
     * �ռ临�Ӷ�ΪO(3)  Ϊԭ�����򣬲�û�н����Ƴ�������
     * @param nums
     */
    public static void sortColorBall(int[] nums){

        int[] temp = new int[3];
        int i = 0;
        for (int x: nums){
            if(x == 0){
                nums[i] = 0;
                i++;
            }else {
                temp[x]++;//����֮������temp������±�պú���Ӧ������һһ��Ӧ
            }
        }
        int j;
        for (j = i; j < i + temp[1]; j++){
            nums[j] = 1;
        }

        for (int k = j; k < j + temp[2]; k++){
            nums[k] = 2;
        }
    }

    /**
     * �÷�����˼·�ǲ�������ָ��ֱ��Ӧ�����򣬽����ƶ�
     * ��ʼʱbegin��current��ָ���׸�Ԫ��  endָ��ĩβԪ��
     * 1����currentָ��0������end��current��Ԫ�أ���ͬʱ��1
     * 2����currentָ��1��Ԫ�ز��䣬current��1
     * 3����currentָ��2�� ����end��current��Ԫ�أ�current������ end��1
     *
     * @param nums
     */
    public static void sortColorBall_1(int[] nums){

        int begin = 0, current = 0;
        int end = nums.length - 1;

        while (current <= end){

            if(nums[current] == 0){
                exchange(nums, begin, current);
                current++;
                begin++;
            }

            else if (nums[current] == 1){
                current++;
            }

            else if(nums[current] == 2){
                exchange(nums, current, end);
                end--;
            }
        }
    }

    public static void exchange(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args){

        int[] nums = new int[]{1, 0, 2, 2, 1, 0, 0, 1, 2};
//        sortColorBall(nums);
        sortColorBall_1(nums);
        for (int res: nums){
            System.out.print(res + " ");
        }


    }
}
