package com.coolrandy.leetcode.linked_list;

import com.coolrandy.llinkedlist.ListIntersect;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by randy on 2016/4/9.
 * 给定两个数字，分别代表两个链表
 * First List: 5->6->3 // represents number 563
 * Second List: 8->4->2 // represents number 842
 *
 * 输出 Resultant list: 1->4->0->5 // represents number 1405
 */
public class SumTwoLists {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void sumTwoLists(int num1, int num2){

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (num1 != 0){
            list1.add(num1 % 10);
            num1 = num1 / 10;
        }
        while (num2 != 0){
            list2.add(num2 % 10);
            num2 = num2 / 10;
        }
        int step = 0;
        int i = 0, j = 0;
        for (; i < list1.size() && j < list2.size(); i++, j++){
            int temp = list1.get(i) + list2.get(i);
            if (temp + step>= 10){
                stack.push((temp + step) % 10);
                step = (temp + step) / 10;
            }else {
                stack.push(temp + step);
                step = 0;
            }
        }
        i = i - 1; j = j - 1;
        if (step > 0){
            if (i == list1.size()-1 && j == list2.size()-1){
                stack.push(step);
            }else if (i == list1.size()-1 && j != list2.size()-1){
                while (++j < list2.size()){

                    if (list2.get(j) + step >= 10){
                        stack.push((list2.get(j) + step) % 10);
                        step = (list2.get(j) + step) / 10;
                    }else {
                        stack.push(list2.get(j) + step);
                        step = 0;
                    }
                }
                if (step > 0){
                    stack.push(step);
                }
            }else if (i != list1.size()-1 && j == list2.size()-1){
                while (++i < list1.size()){

                    if (list1.get(i) + step >= 10){
                        stack.push((list1.get(i) + step) % 10);
                        step = (list1.get(i) + step) / 10;
                    }else {
                        stack.push(list1.get(i) + step);
                        step = 0;
                    }
                }
                if (step > 0){
                    stack.push(step);
                }
            }
        }else {
            if (i == list1.size()-1 && j != list2.size()-1){
                while (++j < list2.size()) {
                    stack.push(list2.get(j));
                }

            }else if (i != list1.size()-1 && j == list2.size()-1) {
                while (++i < list1.size()) {
                    stack.push(list1.get(i));
                }
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args){

        sumTwoLists(0, 12);
    }
}
