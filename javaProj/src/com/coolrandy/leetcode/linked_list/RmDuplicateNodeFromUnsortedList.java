package com.coolrandy.leetcode.linked_list;

import java.util.HashMap;

/**
 * Created by randy on 2016/4/7.
 * 从未排序的链表中删除重复节点
 */
public class RmDuplicateNodeFromUnsortedList {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 该方法采用的解法是用一个hashmap存放节点，然后遍历一次查找判断即可，时间复杂度为O(N)，需要大概O（n）的空间复杂度
     * 是以空间换时间
     * 还有一种思路是采用双重循环的方式，时间复杂度为O(N^2)，空间复杂度为O（1）
     * @param head
     * @return
     */
    public static ListNode rmDuplicateNodeFromUnsorted(ListNode head){

        if (null == head){
            return null;
        }

        ListNode p = head, q = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(p.data, 1);
        p = p.next;
        while (p != null){
            if (map.containsKey(p.data)){
                if (map.get(p.data) > 0){
                    p = p.next;
                    q.next = p;
                }
            }else {
                map.put(p.data, 1);
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
        node_1.next = node_2;
        node_2.next = null;

//        ListNode resNode = rmDuplicateNode(node_1);
        ListNode resNode = rmDuplicateNodeFromUnsorted(node1);
        while (resNode != null) {
            System.out.print(resNode.data + " ");
            resNode = resNode.next;
        }
    }
}
