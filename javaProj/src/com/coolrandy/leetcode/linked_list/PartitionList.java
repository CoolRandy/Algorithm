package com.coolrandy.leetcode.linked_list;

/**
 * Created by randy on 2016/4/7.  leetcode 86. Partition List
 * 给定一个链表和节点值x，移动节点使得所有小于x的节点放到不小于x的节点之前
 * eg: 1->4->3->2->5->2    输出 1->2->2->4->3->2   注意这里不需要排序
 *
 * 思路分析：采用两个哑节点，分别对小于x和不小于x的节点进行链表关联
 * 这里关键要掌握哑节点的用处，用于固定两条链路的起始点，这样可以最后将两个链表归并为一个链表
 *
 * 只遍历了一次，时间复杂度为O(N)，采用了两个哑节点 空间复杂度近似为O(1)
 */

//TODO 需再次理解
public class PartitionList {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode partitionList(ListNode head, int val){

        if (null == head){
            return null;
        }

        ListNode pDummy = new ListNode(0);
        ListNode p = pDummy;
        ListNode qDummy = new ListNode(0);
        ListNode q = qDummy;
        ListNode node = head;
        while (node != null){
            if (node.data >= val){
                q.next = node;
                q = q.next;
            }else {
                p.next = node;
                p = p.next;
            }
            node = node.next;
        }
        p.next = qDummy.next;
        q.next = null;
        return pDummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(2);

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

        ListNode resNode = partitionList(node1, 3);
        while (resNode != null) {
            System.out.print(resNode.data + " ");
            resNode = resNode.next;
        }
    }
}
