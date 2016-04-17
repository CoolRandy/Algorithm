package com.coolrandy.leetcode.linked_list;

/**
 * Created by randy on 2016/4/6.
 * leetcode
 * 给定已排序的链表，删除重复元素保证值出现一次
 * 注意：这里是已排序
 */
public class RmDuplicateNode {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode rmDuplicateNode(ListNode head){

        if (null == head){
            return null;
        }
        ListNode p = head;
        ListNode q;
        q = p.next;
        while (q != null){
            if (p.data != q.data) {
                p.next = q;
                p = q;
                q = q.next;
            }else {
                q = q.next;
            }
        }
        //还需要考虑[1, 1]的测试情况
        if (p.next != null){
            p.next = null;
        }
        return head;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);

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

        ListNode resNode = rmDuplicateNode(node_1);
        while (resNode != null){
            System.out.print(resNode.data + " ");
            resNode = resNode.next;
        }
    }
}
