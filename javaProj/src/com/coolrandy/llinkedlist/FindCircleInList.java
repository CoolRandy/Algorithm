package com.coolrandy.llinkedlist;

import com.coolrandy.BaseSort;

import java.util.Set;

/**
 * Created by randy on 2016/3/30.
 * 链表中找环
 */
public class FindCircleInList {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 这里采用双指针来判断
     * @param head
     * @return  如果不存在环，返回0；若存在环，则返回相遇点的值
     */
    public static int findCircleInList(ListNode head){

        if (null == head){
            return 0;
        }

        ListNode p = head, q = head;
        while (p != null && q != null){

            p = p.next;
            if (null == q.next){
                return 0;
            }
            q = q.next.next;

            if (p == q){
                for (p = head; p != q; p = p.next, q = q.next.next);
                return p.data;
            }
        }
        return 0;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.print(findCircleInList(node1));
    }
}
