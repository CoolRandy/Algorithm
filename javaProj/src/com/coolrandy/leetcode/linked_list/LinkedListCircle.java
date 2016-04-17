package com.coolrandy.leetcode.linked_list;

/**
 * Created by randy on 2016/4/9.
 * 判断链表是否有环  要求不能修改链表  如果不使用额外的空间，该如何解决？
 */
public class LinkedListCircle {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 该方法只判断链表是否有环，有的话返回true，否则返回false
     * @param head
     * @return
     */
    public static boolean determineCircle(ListNode head){

        if (null == head || null == head.next){
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return false;
            }
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表是否有环，有的话返回环开始的节点，没有的话返回null
     * @param head
     * @return
     */
    public static ListNode findCircleInList(ListNode head){

        if (null == head || null == head.next){
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (fast == slow){
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args){

            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
//            ListNode node6 = new ListNode(6);
//            ListNode node7 = new ListNode(7);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node3;

        System.out.println(determineCircle(node1));
        System.out.print(findCircleInList(node1).data);
    }

}
