package com.company;

/**
 * Created by admin on 2016/3/18.
 * 删除有序链表的重复节点
 */
public class DeleteRepeatNode {

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode deleteRepeatNode(ListNode head){
        ListNode temp;
        if (null == head){
            return null;
        }
        ListNode p = head;
        while (p.next != null){

            if (p.data == p.next.data){
                temp = p.next;
                p.next = p.next.next;
                temp.next = null;
            }else {
                p = p.next;
            }
        }

        return head;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode res = deleteRepeatNode(node1);
        while (res != null){
            System.out.print(res.data + " ");
            res = res.next;
        }

    }
}
