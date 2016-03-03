package com.company;

/**
 * 合并有序链表:
 * 给定两个单链表，都是递增有序的，将它们合并，使合并后的链表仍然有序
 * 这里采用了递归的思路
 */
public class MergeList {

    /**
     * create Node class
     */
    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public static ListNode mergeList(ListNode aList, ListNode bList){

        if(null == aList){
            return bList;
        }
        if (null == bList){
            return aList;
        }
        ListNode listNode = null;
        if (aList.data < bList.data){
            listNode = aList;
            listNode.next = mergeList(aList.next, bList);
        }else if(aList.data >= bList.data){
            listNode = bList;
            listNode.next = mergeList(aList, bList.next);
        }

        return listNode;
    }

    public static void main(String[] args) {

        ListNode listNode = null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(19);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(11);
        ListNode listNode3 = new ListNode(20);
        ListNode listNode4 = new ListNode(24);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        listNode = mergeList(node1, listNode1);
        System.out.print("listNode: ");
        while (listNode.next != null){
            System.out.print(listNode.data + ", ");
            listNode = listNode.next;
        }
        System.out.println('\n');
    }
}
