package com.coolrandy.leetcode.linked_list;

/**
 * Created by admin on 2016/4/7.
 * 如果重复节点不止一个，则全部删除
 */
public class RmDuplicateNode_2 {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 这里采用了一个技巧就是添加了一个哑节点，因为有可能删除的是头节点   此题初次未实现？？？
     * @param head
     * @return
     */
    public static ListNode rmDuplicateNode_2(ListNode head){

        if (null == head){

            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = dummyNode;

        while (temp.next != null && temp.next.next != null){
            if (temp.next.data == temp.next.next.data) {
                int tempData = temp.next.data;
                while (temp.next != null && tempData == temp.next.data) {
                    temp.next = temp.next.next;
                }
            }else {
                temp = temp.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);

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

//        ListNode resNode = rmDuplicateNode(node_1);
        ListNode resNode = rmDuplicateNode_2(node1);
        while (resNode != null){
            System.out.print(resNode.data + " ");
            resNode = resNode.next;
        }
    }
}
