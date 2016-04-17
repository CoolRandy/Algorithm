package com.coolrandy;

/**
 * Created by randy on 2016/3/8.
 */
public class InsertSort {


    public static void insertSort(int[] a, int n){
        int i = 0, j = 0;
        for (i = 1; i < n; i++){
            int temp = a[i];
            j = i;
            while (j > 0 && temp < a[j-1]){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{1, 4, 3, 54, 23, 36, 18};
        insertSort(a, 7);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
