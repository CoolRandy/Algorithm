package com.coolrandy.leetcode;

import java.util.ArrayList;

/**
 * Created by randy on 2016/4/5.
 * https://gist.github.com/benjaminwu7
 */
public class Triangle {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);

        ArrayList<int[]> dp = new ArrayList<int[]>();

        for(int i = 0; i < triangle.size() - 1; i++){
            dp.add(new int[i + 1]);
        }

        return find(dp, 0, 0, triangle);

    }

    public static int find(ArrayList<int[]> dp, int row, int colum, ArrayList<ArrayList<Integer>> triangle){
        if(row == triangle.size() - 1){
            return triangle.get(row).get(colum);
        }

        if(dp.get(row)[colum] == 0){
            dp.get(row)[colum] = triangle.get(row).get(colum) +
                    Math.min(find(dp, row + 1, colum, triangle), find(dp, row + 1, colum + 1, triangle));
        }

        return dp.get(row)[colum];
    }


    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(2);
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(3);
        array2.add(4);
        ArrayList<Integer> array3 = new ArrayList<>();
        array3.add(6);
        array3.add(5);
        array3.add(7);
        ArrayList<Integer> array4 = new ArrayList<>();
        array4.add(4);
        array4.add(1);
        array4.add(8);
        array4.add(3);
        triangle.add(array1);
        triangle.add(array2);
        triangle.add(array3);
        triangle.add(array4);

        System.out.print(minimumTotal(triangle));
    }
}
