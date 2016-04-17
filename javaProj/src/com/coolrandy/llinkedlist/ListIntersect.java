package com.coolrandy.llinkedlist;

/**
 * Created by randy on 2016/3/31.
 * 简化：判断两个单链表是否相交
 */
public class ListIntersect {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }
    public static boolean listIntersect(ListNode node1, ListNode node2){

        if (null == node1 || null == node2){

            return false;
        }

        while (node1.next != null){
            node1 = node1.next;
        }

        while (node2.next != null){
            node2 = node2.next;
        }

        return (node1 == node2);
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node7.next = node8;
        node8.next = node9;
        node9.next = node4;

        System.out.print(listIntersect(node1, node7));
    }

}
