package com.company;

/**
 * 问题描述：合并两个已排序的数组，其中一数组大小可以容纳所有元素
 * 细节问题：数组重复元素，数组溢出
 */

public class MergeSort {

    public static void mergeArray(int a[], int aLength, int b[], int bLength){

        int totalLength = aLength + bLength - 1;
        aLength--;
        bLength--;
        while(aLength >=0 && bLength >= 0){

            if(a[aLength] > b[bLength]){
                a[totalLength--] = a[aLength--];
            }else if(a[aLength] <= b[bLength]){
                a[totalLength--] = b[bLength--];
            }
        }
        while (aLength < bLength){
            a[totalLength--] = b[bLength--];
        }
    }

    public static void main(String[] args) {
	// write your code here

        int[] a = new int[]{1, 3, 8, 21, 23, 0, 0, 0, 0, 0, 0, 0};
        int[] b = new int[]{2, 4, 9, 11, 16, 23, 46};
        System.out.println("a len: " + a.length + ", b len: " + b.length);
        mergeArray(a, 5, b, 7);

        for(int i = 0; i < a.length; i++){
            System.out.print("res: " + a[i] + ", ");
        }
        System.out.print("\n");
    }
}
