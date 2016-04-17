package com.coolrandy;

/**
 * Created by randy on 2016/3/8.
 */
public class MergeSort {

    public static void merge(int[] a, int low, int mid, int high){

        //¸¨ÖúÊý×é
        int[] tempArray = new int[a.length];
        for (int i = 0; i < a.length; i++){
            tempArray[i] = a[i];
        }
        int i, j, k;
        for (i = low, j = mid+1, k = i; i <= mid &&j <= high; k++){
            if(tempArray[i] < tempArray[j]){
                a[k] = tempArray[i++];
            }
            if (tempArray[i] > tempArray[j]){
                a[k] = tempArray[j++];
            }
        }
        while (i <= mid){
            a[k++] = tempArray[i++];
        }
        while (j <= high){
            a[k++] = tempArray[j++];
        }
    }

    public static void merge_1(int[] a, int low, int mid, int high){

        int right_low = mid + 1;
        int[] temp_array = new int[a.length];
        int index = low;
        int temp = low;
        while (low <= mid && right_low <= high){
            if(a[low] <= a[right_low]){
                temp_array[index++] = a[low++];
            }else {
                temp_array[index++] = a[right_low++];
            }
        }

        while (low <= mid){
            temp_array[index++] = a[low++];
        }

        while (right_low <= high){
            temp_array[index++] = a[right_low++];
        }

        while (temp <= high){
            a[temp] = temp_array[temp++];
        }
    }

    public static void mergeSort(int[] a, int low, int high){

        if(low < high){
            int mid = low + ((high - low) >> 1);
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge_1(a, low, mid, high);
        }
    }

    public static void main(String[] args){

        int[] a = new int[]{1, 3, 2, 45, 32, 7, 12, 9, 23};
        mergeSort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
