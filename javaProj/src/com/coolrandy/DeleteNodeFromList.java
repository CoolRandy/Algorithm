package com.coolrandy;

/**
 * Created by randy on 2016/3/5.
 * 删除链表中的节点
 */
public class DeleteNodeFromList {

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 如果只知道要删除的节点，如何在时间复杂度O(1)的情况下删除该节点
     * 思路很简单：就是用后继节点覆盖掉，然后删除后继节点   注：这里没有考虑删除节点是尾节点的情况,对于尾节点
     * 是没法在O(1)的时间复杂度下删除掉的
     * 可以考虑利用双指针，在O(n)的时间复杂度下完成尾节点删除,且前提是知道链表头指针,空间复杂度为O(1)
     * @param listNode
     */
    public static void deleteNode(ListNode head, ListNode listNode){

        if(listNode == null || null == head){
            return;
        }
        if(listNode != null && listNode.next != null) {
            listNode.data = listNode.next.data;
            listNode.next = listNode.next.next;
        }else if(null == listNode.next){
            ListNode priNode = head.next;
            while (priNode.next != null){
                head = head.next;
                priNode = priNode.next;
            }
            head.next = null;
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
        ListNode listNode = node1;
        deleteNode(listNode, node1);
        while (listNode != null){
            System.out.print(listNode.data + " ");
            listNode = listNode.next;
        }
    }
}
