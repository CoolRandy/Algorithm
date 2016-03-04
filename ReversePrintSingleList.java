package com.coolrandy;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;
import java.util.ArrayList;

/**
 * Created by randy on 2016/3/4.
 * 倒序打印一个单链表：有两种思路，1、先将链表反转，然后遍历打印  时间复杂度为O(2N) 使用了一个辅助变量，空间复杂度O(1)
 *                  2、采用递归打印的方式，正好是从递归的底部开始打印，实现倒序
 */
public class ReversePrintSingleList {

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 递归打印
     * @param listNode
     */
    public static void reversePrintList(ListNode listNode){

        if(listNode != null){
            reversePrintList(listNode.next);
            System.out.print(listNode.data + " ");
        }
    }

    /**
     * 根据牛客的提测系统进行的编码
     * 采用的仍然是递归，本质上采用的 堆栈结构
     */
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(listNode != null){
                list = printListFromTailToHead(listNode.next);
                list.add(listNode.data);
            }
            return list;
        }
    }

    /**
     * 反转链表
     * @param listNode
     */
    public static ListNode reverseSingleList(ListNode listNode){

        ListNode tempNode;
        ListNode prevNode = null;
        while (listNode.next != null){
            //首先记下listNode的下一节点
            tempNode = listNode.next;
            //将listNode指向prevNode的下一节点
            listNode.next = prevNode;
            //后移节点
            prevNode = listNode;
            listNode = tempNode;
        }
        listNode.next = prevNode;

        return listNode;
    }
    public static void main(String[] args){

        boolean isRecursion = true;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        if(isRecursion){
            long startTime = System.currentTimeMillis();
            reversePrintList(node1);
            long endTime = System.currentTimeMillis();
            System.out.print("\n run time is: ");
            System.out.print(endTime - startTime);

        }else {
            ListNode listNode = reverseSingleList(node1);
            do{
                System.out.print(listNode.data + " ");
                listNode = listNode.next;
            }while (listNode != null);
        }

    }
}
