package com.coolrandy.llinkedlist;

/**
 * Created by randy on 2016/3/30.
 * ����������
 *
 * ��������ֻ֧��˳���������֧���������
 */
public class SortLinklist {

    public class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node getMiddle(Node head){

        if (null == head){
            return head;
        }
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


}
