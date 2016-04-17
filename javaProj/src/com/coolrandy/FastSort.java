package com.coolrandy;

/**
 * Created by randy on 2016/3/19.
 */
public class FastSort {



        public int partition(int[] nums){
            int length = nums.length;
            int low = 0, high = length - 1;
            int pivot = nums[low];
            while(low < high){
                while(low < high && pivot <= nums[high]){
                    high--;
                }
                nums[low] = nums[high];
                while(low < high && pivot >= nums[low]){
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            return low;
        }
        public void sortColors(int[] nums, int low, int high) {

//            int low = 0, high = nums.length - 1;
            if(low == high){
                return;
            }
            if(low < high){
                int pivot = partition(nums);
                sortColors(nums, low, pivot - 1);
                sortColors(nums, pivot + 1, high);
            }
        }

}
