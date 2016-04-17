package com.coolrandy;

/**
 * Created by randy on 2016/3/19.
 * 题目描述：给定一个数组包含三种颜色的球，分别为红、白、蓝，为方便表示分别用数字0、1、2进行表示，顺序是打乱的
 * 需要进行排序，将相同颜色的球放到一起，按照红白蓝的顺序
 * 实际上该问题就是荷兰国旗问题
 */
public class SortColorBall {

    /**
     * 此方法的思路是采用新建一个数组temp分别存放rwb三种颜色的球数，初始值为0
     * 然后首先将红球先排好序，同时计算白球和蓝球的数量，存放到temp数组对应的下标中
     * 等红球排好序之后，依次按照白球和蓝球的数量进行赋值，这样就完成了排序
     * 空间复杂度为O(3)  为原地排序，并没有将球移除数组外
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
                temp[x]++;//巧妙之处在于temp数组的下标刚好和相应的数字一一对应
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
     * 该方法的思路是采用三个指针分别对应三种球，进行移动
     * 初始时begin和current都指向首个元素  end指向末尾元素
     * 1、当current指向0，交换end和current的元素，并同时加1
     * 2、当current指向1，元素不变，current加1
     * 3、当current指向2， 交换end和current的元素，current不动， end减1
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
