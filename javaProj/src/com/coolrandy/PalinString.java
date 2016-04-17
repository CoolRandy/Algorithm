package com.coolrandy;

import java.util.Stack;

/**
 * Created by randy on 2016/3/17.
 */
public class PalinString {
    /**
     * ����ջ�ķ�ʽʵ��  ʱ�临�Ӷ�ΪO(2n)   �ռ临�Ӷ�ΪO(n)
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
     * ���ô��ַ����������м�����Ƚ�
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
     * ʵ�ֵ�����Ļ����жϣ�˼·
     * ���Ȳ��ÿ���ָ�붨λ���м�λ�ã�Ȼ����м�λ�ý����������ת
     * ���ŷֱ���������м�����Ƚ�
     * ʱ�临�Ӷ�ΪO(N/2) + O(N/2) + O(N/2)  �ռ临�Ӷ�O(����)
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
        //ż������������һ��
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
