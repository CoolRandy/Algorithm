package com.coolrandy.string;

/**
 * Created by randy on 2016/3/30.
 * LeetCode 328  ��ż���ڵ�������ڵ�ֿ�����ż�����������ĺ���
 *
 * ��һ���뷨���Ǳ���
 */
public class DivideOddEven {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode divideOddEven(ListNode head){

        if (null == head){
            return null;
        }

        ListNode odd_head = null, odd_tail = null;
        ListNode even_head = null, even_tail = null;

        for (int i = 1; head != null; i++, head = head.next){

            if (1 == (i & 1)){
                //����
                if (odd_tail != null){
                    odd_tail = odd_tail.next = head;
                }else {
                    odd_head = odd_tail = head;
                }
            }else if (0 == (i & 1)){
                //ż��
                if (even_tail != null){
                    even_tail = even_tail.next = head;
                }else {
                    even_head = even_tail = head;
                }
            }
        }

        if (odd_tail != null){//��������Ϊnull
            odd_tail.next = even_head;
        }else {//��������Ϊ��

            odd_head = even_head;
        }

        if (even_tail != null){
            even_tail.next = null;
        }

        return odd_head;

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
        node5.next = null;

        ListNode res = divideOddEven(node1);
        while (res != null){
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}
