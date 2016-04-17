package com.coolrandy;

import java.util.Stack;

/**
 * Created by randy on 2016/3/17.
 */
public class PalinString {
    /**
     * 采用栈的方式实现  时间复杂度为O(2n)   空间复杂度为O(n)
     * @param str
     * @return
     */
    public static boolean isPalinString(String str){
        if (null == str){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            stack.add(str.charAt(i));
        }

        for (int j = 0; j < str.length(); j++){
            if(str.charAt(j) != stack.pop()){
                return false;
            }
        }

        return true;
    }

    /**
     * 采用从字符串两边向中间遍历比较
     * @param str
     * @return
     */
    public static boolean isPalin(String str){
        if(null == str){
            return false;
        }

        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 实现单链表的回文判断：思路
     * 首先采用快慢指针定位到中间位置，然后从中间位置将后面的链表反转
     * 接着分别从两边向中间遍历比较
     * 时间复杂度为O(N/2) + O(N/2) + O(N/2)  空间复杂度O(常量)
     * @param head
     * @return
     */
    public static boolean isListPalin(ListNode head){
        if (null == head){
            return false;
        }
        ListNode prevNode = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //偶数和奇数处理一样
        while (slow.next != null){
            temp = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = temp;
        }

        slow.next = prevNode;

        while (slow != null && head != null){
            if(slow.data != head.data){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args){

        String string1 = "werew";
        String string2 = "wertew";
        System.out.println(isPalinString(string1));
        System.out.println(isPalinString(string2));

        System.out.println(isPalin(string1));
        System.out.println(isPalin(string2));

        ListNode node = null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println(isListPalin(node1));
        System.out.println(isListPalin(node));
    }
}
