package com.coolrandy;

/**
 * Created by randy on 2016/3/8.
 * ϣ������  �Ƕ�ֱ�Ӳ�������ĸĽ�
 */
public class ShellSort {

    public static void shellSort(int[] a, int n){

        int i, j;
        int k = n / 2;
        while (k > 0){
            for (i = k; i < n; i++){
                int temp = a[i];
                j = i;
                while (j >= k && temp < a[j - k]){
                    a[j] = a[j-k];
                    j = j - k;
                }
                a[j] = temp;
            }
            k /= 2;
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{1, 4, 3, 54, 23, 36, 18};
        shellSort(a, 7);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
