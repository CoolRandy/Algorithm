package com.coolrandy;

import java.util.ArrayList;

/**
 * Created by randy on 2016/3/21.
 * 有两个有序的集合，集合的每个元素都是一段范围，求其交集，例如集合{[4,8],[9,13]}和{[6,12]}的交集为{[6,8],[9,12]}
 * 思路：这里考察了面向对象的解决思路
 * 对于集合内部的元素[a,b],定义一个对象来表示
 */
public class SetMerge {

    static class Range{
        int left;//左边界值
        int right;//右边界值

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static ArrayList<Range> setMerge(Range[] range1, Range[] range2){
        ArrayList<Range> ranges = new ArrayList<>();
        for (int i = 0; i < range1.length; i++){
            for (int j = 0; j < range2.length; j++){
                if(range2[j].right < range1[i].left){
                    j++;
                    if(j == range1.length){
                        break;
                    }else {
                        if(range2[j].right > range1[i].left){
                            int left = range2[j].left > range1[i].left? range2[j].left : range1[i].left;
                            int right = range2[j].right < range1[i].right? range2[j].right : range1[j].right;
                            Range newRange = new Range(left, right);
                            ranges.add(newRange);
                        }
                    }
                }
                else if (range2[j].left > range1[i].right) {
                    break;
                }
                else if(range2[j].right > range1[i].left){
                        int left = range2[j].left > range1[i].left? range2[j].left : range1[i].right;
                        int right = range2[j].right < range1[i].right? range2[j].right : range1[j].right;
                        Range newRange = new Range(left, right);
                        ranges.add(newRange);

                }
            }
        }

        return ranges;
    }

    public static void main(String[] args){

        Range range1 = new Range(6, 12);
        Range range2 = new Range(24, 40);

        Range range3 = new Range(8, 16);
        Range range4 = new Range(20, 35);

        Range[] aR = new Range[]{range1, range2};
        Range[] bR = new Range[]{range3, range4};
        ArrayList<Range> ranges = setMerge(aR, bR);
        System.out.print("(");
        for (Range range: ranges){
            System.out.print("[" + range.left + ", " + range.right + "]， ");
        }
        System.out.print(")");
    }
}
