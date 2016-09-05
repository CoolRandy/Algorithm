package com.coolrandy.offer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by randy on 2016/9/5.
 * 面试题15，求解链表中倒数第k个节点
 */
public class LastKthElement {

    private static class ListNode{

        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private static int getLastKthElement(ListNode head, int k){
        if (null == head){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null){
            map.put(++i, head.value);
            head = head.next;
        }
        if (k > i){
            return -1;
        }
        int result = map.get(i-k+1);
        return result;
    }

    /**
     * 拓展题目： 求链表的中间节点
     * 这个比较简单，快指针一次走两步，慢指针一次走一步，当快指针走到链尾时，慢指针即走到了中间
     * 判断链表是否有环，这个同样是采用快慢指针进行处理
     * @param args
     */

    public static void main(String[] args){

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(27);
        ListNode node4 = new ListNode(17);
        ListNode node5 = new ListNode(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println("last kth element id: " + getLastKthElement(node1, 6));
    }
}
