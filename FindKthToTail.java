package com.coolrandy;

/**
 * Created by randy on 2016/3/4.
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head,int k) {

        int i = 1;
        ListNode p = head;
        if(head != null && k > 0){
            while(i < k){
                if(p.next != null){
                    p = p.next;
                    i++;
                }else{
                    return null;
                }
            }
            while(head.next != null && p.next != null){
                head = head.next;
                p = p.next;
            }
            return head;

        }else{
            return null;
        }
    }


    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode emptyNode = null;
        ListNode listNode1;
        ListNode listNode2;
        ListNode listNode3;
        ListNode listNode4;
        ListNode listNode5;
        ListNode listNode6;
        listNode1 = FindKthToTail(node1, 4);
        listNode2 = FindKthToTail(node1, 2);
        listNode3 = FindKthToTail(node1, 1);
        listNode4 = FindKthToTail(node1, 0);
        listNode5 = FindKthToTail(node1, 6);
        listNode6 = FindKthToTail(emptyNode, 6);

        System.out.print("1: " + listNode1.val + ", 2: " + listNode2.val
                    + ", 3: " + listNode3.val + ", 4: " + listNode4
                    + ", 5: " + listNode5 + ", 6: " + listNode6);
    }

}
