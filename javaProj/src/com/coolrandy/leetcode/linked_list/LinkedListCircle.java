package com.coolrandy.leetcode.linked_list;

/**
 * Created by randy on 2016/4/9.
 * �ж������Ƿ��л�  Ҫ�����޸�����  �����ʹ�ö���Ŀռ䣬����ν����
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
     * �÷���ֻ�ж������Ƿ��л����еĻ�����true�����򷵻�false
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
     * �ж������Ƿ��л����еĻ����ػ���ʼ�Ľڵ㣬û�еĻ�����null
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
